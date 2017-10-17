package id.co.telkomsigma.etc.cbo.integration.transaction.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import id.co.telkomsigma.etc.cbo.data.CBOConstant.Query;
import id.co.telkomsigma.etc.cbo.data.dto.response.balanceinfo.BalanceInfoQueryListItemDTO;
import id.co.telkomsigma.etc.cbo.data.dto.response.balanceinfo.BalanceInfoQueryListResponseDTO;
import id.co.telkomsigma.etc.cbo.data.model.LogHitOther;
import id.co.telkomsigma.etc.cbo.data.model.ReferenceList;
import id.co.telkomsigma.etc.cbo.integration.transaction.ICBOTransactionConstant;
import id.co.telkomsigma.etc.cbo.integration.transaction.client.BalanceInfoListQueryClient;
import id.co.telkomsigma.etc.cbo.integration.transaction.service.*;
import id.co.telkomsigma.tmf.data.constant.TMFConstant.Common.Punctuation;
import id.co.telkomsigma.tmf.service.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
    ILogHitOtherService logHitOtherService;

    @Autowired
    BalanceInfoListQueryClient balanceInfoListQueryClient;

    @Autowired
    ISubscriberService subscriberService;

    @Autowired
    IReferenceListService referenceListService;

    @Autowired
    IProcessLog2Service processLog2Service;

    @Autowired
    IStatusListService statusListService;

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
}
