package id.co.telkomsigma.etc.cbo.integration.transaction.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import id.co.telkomsigma.etc.cbo.data.CBOConstant.Query;
import id.co.telkomsigma.etc.cbo.data.dto.request.querylist.RequestQueryListDTO;
import id.co.telkomsigma.etc.cbo.data.dto.response.ChargeProsesStatusContentDTO;
import id.co.telkomsigma.etc.cbo.data.dto.response.ResponseChargeProcessStatusDTO;
import id.co.telkomsigma.etc.cbo.data.dto.response.balanceinfo.BalanceInfoQueryListItemDTO;
import id.co.telkomsigma.etc.cbo.data.dto.response.balanceinfo.BalanceInfoQueryListResponseDTO;
import id.co.telkomsigma.etc.cbo.data.model.*;
import id.co.telkomsigma.etc.cbo.integration.transaction.ICBOTransactionConstant;
import id.co.telkomsigma.etc.cbo.integration.transaction.client.BalanceInfoListQueryClient;
import id.co.telkomsigma.etc.cbo.integration.transaction.client.BalanceInfoListQueryV2Client;
import id.co.telkomsigma.etc.cbo.integration.transaction.service.*;
import id.co.telkomsigma.etc.cbo.integration.transaction.topic.StatusListTopicProducer;
import id.co.telkomsigma.etc.cbo.shared.data.StatusListContentDTO;
import id.co.telkomsigma.etc.cbo.shared.data.StatusListDTO;
import id.co.telkomsigma.tmf.data.constant.TMFConstant.Common.Punctuation;
import id.co.telkomsigma.tmf.service.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created on 10/13/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class BalanceInfoQueryListServiceImpl implements IBalanceInfoQueryListService {

    @Autowired
    private ILogHitOtherService logHitOtherService;

    @Autowired
    private BalanceInfoListQueryClient balanceInfoListQueryClient;

    @Autowired
    private BalanceInfoListQueryV2Client balanceInfoListQueryV2Client;

    @Autowired
    private ISubscriberService subscriberService;

    @Autowired
    private IReferenceListService referenceListService;

    @Autowired
    private IProcessLog2Service processLog2Service;

    @Autowired
    private IStatusListService statusListService;

    @Autowired
    private IEventInputService eventInputService;

    @Autowired
    private IEventUnRatedService eventUnRatedService;

    @Autowired
    private IEventRatedService eventRatedService;

    @Autowired
    private StatusListTopicProducer statusListTopicProducer;

    private static final Logger LOGGER = LoggerFactory.getLogger(BalanceInfoQueryListServiceImpl.class);

    @Override
    public Long insertLogBiAndBl(String p_ErrorResponse, String p_FlagLog, String p_FlagStatus, Long p_IdLog) {
        Long result = null;
        if (p_FlagStatus.equals(Query.FLAG_STATUS_HIT_INSERT)) {
            LogHitOther logHitOther = new LogHitOther();
            logHitOther.setDateRequest(new Date());
            logHitOther.setFlagLog(p_FlagLog);
            logHitOther.setErrorResponse(p_ErrorResponse);
            try {
                logHitOtherService.insert(logHitOther);
            } catch (ServiceException e) {
                LOGGER.error("Error insert Log Hit Other ".concat(e.toString()));
            }
            result = logHitOther.getId();
        }else if (p_FlagStatus.equals(Query.FLAG_STATUS_HIT_UPDATE)) {
            if (p_IdLog != null) {
                LogHitOther toUpdateLogHit = null;
                try {
                    toUpdateLogHit = logHitOtherService.findById(p_IdLog);
                    if (toUpdateLogHit != null) {
                        toUpdateLogHit.setErrorResponse(p_ErrorResponse);
                        toUpdateLogHit.setFlagLog(p_FlagLog);
                        toUpdateLogHit.setLogDate(new Date());
                        logHitOtherService.update(toUpdateLogHit);
                        result = toUpdateLogHit.getId();
                    } else {
                        LOGGER.warn("Can not update LogHitOther, Prev. Id is Not Found");
                    }
                } catch (ServiceException e) {
                    LOGGER.error("Error to Find updated Log Hit Data ".concat(e.toString()));
                }
            }
        }
        return result;
    }

    @Override
    public void conduct() {
        Long p_InsertedId = insertLogBiAndBl(Punctuation.EMPTY, Query.FLAG_LOG_BI, Query.FLAG_STATUS_HIT_INSERT, null);

        BalanceInfoQueryListResponseDTO balanceInfoQueryListResponseDTO = balanceInfoListQueryClient.queryClient();
        if (balanceInfoQueryListResponseDTO != null) {
            if (balanceInfoQueryListResponseDTO.getError().equals(Punctuation.EMPTY)) {
                ObjectMapper mapper = new ObjectMapper();
                try {
                    insertLogBiAndBl(mapper.writeValueAsString(balanceInfoQueryListResponseDTO.getData().getBalanceInfoItems()), Query.FLAG_LOG_BI, Query.FLAG_STATUS_HIT_UPDATE, p_InsertedId);
                    if (balanceInfoQueryListResponseDTO.getData().getBalanceInfoItems() != null && balanceInfoQueryListResponseDTO.getData().getBalanceInfoItems().size() > 0) {
                        for (BalanceInfoQueryListItemDTO balanceInfoQueryListItemDTO : balanceInfoQueryListResponseDTO.getData().getBalanceInfoItems()) {
                            insertStatusListBli(balanceInfoQueryListItemDTO.getAccountId(), balanceInfoQueryListItemDTO.getBalanceAmount(), balanceInfoQueryListItemDTO.getBalanceQueriedAt());
                        }
                    }
                } catch (JsonProcessingException e) {
                    LOGGER.error("Error Parsing Json Response "+e.toString());
                }
                packCreateStatusList();
            } else {
                insertLogBiAndBl(balanceInfoQueryListResponseDTO.getError(), Query.FLAG_LOG_BI, Query.FLAG_STATUS_HIT_UPDATE, p_InsertedId);
            }
        }
    }


    @Override
    public void packCreateStatusList() {
        List<ReferenceList> referenceLists = referenceListService.findByCode(ICBOTransactionConstant.ReferenceListCode.STATUS_LIST);
        if (referenceLists.size() > 0){
            try {
                processLog2Service.writeMessage(Integer.parseInt(String.valueOf(referenceLists.get(0).getId())), "Mulai proses ...", null, null, null, null);
                Long filteredCountStatusList = statusListService.countStatusListByEMoneyAndFlagSourceAndIsWrite();
                if (filteredCountStatusList > 0){
                    /*p_create_file_bulk*/
                }

                Long filteredCountStatusList2 = statusListService.countStatusListByEMoneyAndFlagSourceAndIsWriteAndInputDataControl();
                if (filteredCountStatusList2 > 0){
                    /*p_create_file_incr*/
                }
            } catch (ServiceException e) {
                LOGGER.error("Error Writing Message Process Log 2", e.toString());
            }

        }

    }

    @Override
    public void insertStatusListBli(String p_AccountId, BigDecimal p_BalanceAmount, Date p_BalanceQueriedAt) {
        Integer nExistingEMoney = selectExistingEMoney(p_AccountId);

    }

    @Override
    public Integer selectExistingEMoney(String p_EMoneyId) {
        return Integer.parseInt(String.valueOf(subscriberService.countByServiceNo(p_EMoneyId)));
    }

    @Override
    public void conductV2() {
        List<EventInput> eventInputs;
        try {
            eventInputs = eventInputService.findByIsHit(ICBOTransactionConstant.IsHitEventInput.BATCH_START);
            if (eventInputs.size() > 0) {

                RequestQueryListDTO requestQueryListDTO = new RequestQueryListDTO();
                List<String> externalIds = new ArrayList<>();
                for (EventInput eventInput : eventInputs){
                    externalIds.add(eventInput.getUuidInput());
                }
                requestQueryListDTO.setExternalIds(externalIds);
                MultiValueMap<String, String> mvmHeaders = new LinkedMultiValueMap<>();
                mvmHeaders.add("Content-Type", "application/json");

                Date timeStampRequestQL = new Date();
                ResponseChargeProcessStatusDTO responseChargeProcessStatusDTO = balanceInfoListQueryV2Client.queryClient(mvmHeaders, requestQueryListDTO);
                if (responseChargeProcessStatusDTO.getChargeProcessStatuses() != null) {
                    if (responseChargeProcessStatusDTO.getChargeProcessStatuses().size() > 0) {
                        StatusListDTO statusListDTO = new StatusListDTO();
                        List<StatusListContentDTO> statusListContentDTOList = new ArrayList<>();
                        for (ChargeProsesStatusContentDTO content : responseChargeProcessStatusDTO.getChargeProcessStatuses()) {
                            EventInput processedEI = eventInputService.findByUuidInput(content.getExternalId());
                            if (processedEI != null) {
                                if (content.getProcessStatus().equals("FailedToStart")){
                            /*DO Nothing*/
                                } else if (content.getProcessStatus().equals("FinishedSuccessfully")) {
                                    processedEI.setIsHit(ICBOTransactionConstant.IsHitEventInput.QUERY_LIST);
                                    eventInputService.update(processedEI);
                                    //insert event rated
                                    EventRated eventRated = new EventRated();
                                    eventRated.setTimestamps(new Date());
                                    eventRated.setBankTrxId(content.getCmnId());
                                    eventRated.setReferenceCode(processedEI.getTrxRefferenceCode());
                                    eventRated.setRowId(content.getExternalId());
                                    eventRated.setTimestampProc(timeStampRequestQL);
                                    eventRated.setResultCode(content.getResultCode());
                                    eventRated.setBalanceInfo(Double.valueOf(String.valueOf(content.getBalanceInfo().getBalanceAmount())));
                                    eventRated.setStartDateClm(content.getStartDate());
                                    eventRated.setTransferDateClm(content.getTransferDate());
                                    eventRatedService.insert(eventRated);

                                    StatusListContentDTO statusListContentDTO = new StatusListContentDTO();
                                    statusListContentDTO.setRecordType("1");
                                    statusListContentDTO.setPan(processedEI.getPan());
                                    LOGGER.info("BALANCE TO SEND TOPIC "+content.getBalanceInfo().getBalanceAmount());
                                    statusListContentDTO.setBalance(String.valueOf(content.getBalanceInfo().getBalanceAmount()));
                                    statusListContentDTO.setStatusFlags("0");
                                    statusListContentDTOList.add(statusListContentDTO);

                                } else if (content.getProcessStatus().equals("FinishedFailure")) {
                                    processedEI.setIsHit(ICBOTransactionConstant.IsHitEventInput.FAILED_CHARGE_BATCH);
                                    eventInputService.update(processedEI);
                                    //insert event unrated
                                    EventUnRated eventUnRated = new EventUnRated();
                                    eventUnRated.setPan(processedEI.getPan());
                                    eventUnRated.seteMoneyId(content.getBalanceInfo().getAccountId());
                                    eventUnRated.setTrxAmount(processedEI.getTrxAmount());
                                    eventUnRated.setTbRowId(content.getExternalId());
                                    eventUnRated.setTimestampTr(processedEI.getEventBeginTime());
                                    eventUnRated.setResultCode(content.getResultCode());
                                    eventUnRated.setTrxCmnId(content.getCmnId());
                                    eventUnRatedService.insert(eventUnRated);
                                }
                            }
                        }

                        LOGGER.info("Status List size "+statusListContentDTOList.size());
                        if (statusListContentDTOList.size() > 0){
                            statusListDTO.setContents(statusListContentDTOList);
                            statusListTopicProducer.send(statusListDTO);
                            LOGGER.info("SCHEDULER HAS SENT STATUS LIST TO TOPIC CONSUMER");
                        }
                    }
                }
            }
        } catch (ServiceException e) {
            LOGGER.error("Error selection event inputs ".concat(e.toString()));
        }

    }
}
