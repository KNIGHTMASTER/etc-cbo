package id.co.telkomsigma.etc.cbo.integration.transaction.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import id.co.telkomsigma.etc.cbo.data.CBOConstant.Query;
import id.co.telkomsigma.etc.cbo.data.dto.request.querylist.RequestQueryListDTO;
import id.co.telkomsigma.etc.cbo.data.dto.response.ChargeProsesStatusContentDTO;
import id.co.telkomsigma.etc.cbo.data.dto.response.ResponseChargeProcessStatusDTO;
import id.co.telkomsigma.etc.cbo.data.dto.response.querylist.BalanceInfoItemDTO;
import id.co.telkomsigma.etc.cbo.data.dto.response.querylist.QueryListResponseDTO;
import id.co.telkomsigma.etc.cbo.data.model.*;
import id.co.telkomsigma.etc.cbo.integration.transaction.ICBOTransactionConstant;
import id.co.telkomsigma.etc.cbo.integration.transaction.client.ListQueryClient;
import id.co.telkomsigma.etc.cbo.integration.transaction.client.ListQueryV2Client;
import id.co.telkomsigma.etc.cbo.integration.transaction.service.*;
import id.co.telkomsigma.etc.cbo.integration.transaction.topic.StatusListTopicProducer;
import id.co.telkomsigma.etc.cbo.shared.data.StatusListContentDTO;
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
public class QueryListServiceImpl implements IQueryListService {

    @Autowired
    private ILogHitOtherService logHitOtherService;

    @Autowired
    private ListQueryClient listQueryClient;

    @Autowired
    private ListQueryV2Client listQueryV2Client;

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

    @Autowired
    private ILogTrxService logTrxService;

    private static final Logger LOGGER = LoggerFactory.getLogger(QueryListServiceImpl.class);

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
                LogHitOther toUpdateLogHit;
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

        QueryListResponseDTO queryListResponseDTO = listQueryClient.queryClient();
        if (queryListResponseDTO != null) {
            if (queryListResponseDTO.getError().equals(Punctuation.EMPTY)) {
                ObjectMapper mapper = new ObjectMapper();
                try {
                    insertLogBiAndBl(mapper.writeValueAsString(queryListResponseDTO.getData().getBalanceInfoItems()), Query.FLAG_LOG_BI, Query.FLAG_STATUS_HIT_UPDATE, p_InsertedId);
                    if (queryListResponseDTO.getData().getBalanceInfoItems() != null && queryListResponseDTO.getData().getBalanceInfoItems().size() > 0) {
                        for (BalanceInfoItemDTO queryListItemDTO : queryListResponseDTO.getData().getBalanceInfoItems()) {
                            insertStatusListBli(queryListItemDTO.getAccountId(), queryListItemDTO.getBalanceAmount(), queryListItemDTO.getBalanceQueriedAt());
                        }
                    }
                } catch (JsonProcessingException e) {
                    LOGGER.error("Error Parsing Json Response "+e.toString());
                }
                packCreateStatusList();
            } else {
                insertLogBiAndBl(queryListResponseDTO.getError(), Query.FLAG_LOG_BI, Query.FLAG_STATUS_HIT_UPDATE, p_InsertedId);
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
        LogTrx logTrx = new LogTrx();
        try {
            eventInputs = eventInputService.findByIsHit(ICBOTransactionConstant.IsHitEventInput.BATCH_START);
            LOGGER.info("Event Input Size "+eventInputs.size());
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
                ObjectMapper mapper = new ObjectMapper();
                logTrx.setTrxReq(mapper.writeValueAsString(requestQueryListDTO));
                logTrx.setLogDate(timeStampRequestQL);

                LOGGER.info("Accessing Rest");
                ResponseChargeProcessStatusDTO responseChargeProcessStatusDTO = listQueryV2Client.queryClient(mvmHeaders, requestQueryListDTO);
                if (responseChargeProcessStatusDTO.getChargeProcessStatuses() != null) {
                    if (responseChargeProcessStatusDTO.getChargeProcessStatuses().size() > 0) {
//                        StatusListDTO statusListDTO = new StatusListDTO();
                        List<StatusListContentDTO> statusListContentDTOList = new ArrayList<>();
                        for (ChargeProsesStatusContentDTO content : responseChargeProcessStatusDTO.getChargeProcessStatuses()) {
                            logTrx.setTbRowId(content.getExternalId());
                            LOGGER.info("External Id "+content.getExternalId());
                            EventInput processedEI = eventInputService.findByUuidInput(content.getExternalId());
                            LOGGER.info("process status "+content.getProcessStatus());
                            LOGGER.info("full json response "+content.toString());
                            if (processedEI != null) {
                                if (content.getProcessStatus().equals("FailedToStart")){
                                    /*DO Nothing*/
                                    LOGGER.info("status : failed to start");
                                    logTrx.setErrorReq(mapper.writeValueAsString(requestQueryListDTO.getExternalIds()));
                                    logTrx.setUpdateRespon(new Date());
                                } else if (content.getProcessStatus().equals("FinishedSuccessfully")) {
                                    LOGGER.info("Status : Finished SuccessFully");
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

                                    logTrx.setTrxResp(mapper.writeValueAsString(content));
                                    logTrx.setUpdateRespon(new Date());

                                    /*LOGGER.info("BALANCE TO SEND TOPIC "+content.getBalanceInfo().getBalanceAmount());*/
                                    StatusListContentDTO statusListContentDTO = new StatusListContentDTO();
                                    statusListContentDTO.setRecordType("1");
                                    statusListContentDTO.setPan(processedEI.getPan());
                                    statusListContentDTO.setBalance(String.valueOf(content.getBalanceInfo().getBalanceAmount()));
                                    statusListContentDTO.setStatusFlags("0");
                                    statusListContentDTOList.add(statusListContentDTO);
                                } else if (content.getProcessStatus().equals("FinishedFailure")) {
                                    /*processedEI.setIsHit(ICBOTransactionConstant.IsHitEventInput.FAILED_CHARGE_BATCH);
                                    eventInputService.update(processedEI);*/

                                    LOGGER.info("Status : Finished Failure");
                                    logTrx.setErrorReq(mapper.writeValueAsString(requestQueryListDTO));
                                    logTrx.setErrorResp(mapper.writeValueAsString(content));
                                    logTrx.setUpdateRespon(new Date());

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
                                    LOGGER.info("Event Unrated : "+eventUnRated.toString());
                                    LOGGER.info("Insert Event Unrated");
                                }
                            }
                            logTrxService.insert(logTrx);
                            LOGGER.info("Insert LOG Trx");
                        }

                        /*Sending to AMQ*/
                        /*LOGGER.info("Status List size "+statusListContentDTOList.size());
                        if (statusListContentDTOList.size() > 0){
                            statusListDTO.setContents(statusListContentDTOList);
                            try {
                                statusListTopicProducer.send(statusListDTO);
                            }catch (Exception e) {
                                //IS BROADCASTED ie to make sure QL sent to OPBO
                                LOGGER.error("Messaging Exception occurred ".concat(e.toString()));
                            }
                            LOGGER.info("SCHEDULER HAS SENT STATUS LIST TO TOPIC CONSUMER");
                        }*/
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.error("An Error Occured "+e.toString());
        }

    }
}
