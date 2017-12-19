package id.co.telkomsigma.etc.cbo.integration.transaction.service.impl;

import id.co.telkomsigma.etc.cbo.data.CBOConstant;
import id.co.telkomsigma.etc.cbo.data.dto.response.balanceinfo.BalanceInfoResponseDTO;
import id.co.telkomsigma.etc.cbo.data.dto.response.querylist.BalanceInfoItemDTO;
import id.co.telkomsigma.etc.cbo.data.model.LogHitOther;
import id.co.telkomsigma.etc.cbo.data.model.Subscriber;
import id.co.telkomsigma.etc.cbo.integration.transaction.client.BalanceInfoListQueryClient;
import id.co.telkomsigma.etc.cbo.integration.transaction.service.IBalanceInfoQueryListService;
import id.co.telkomsigma.etc.cbo.integration.transaction.service.ILogHitOtherService;
import id.co.telkomsigma.etc.cbo.integration.transaction.service.ISubscriberService;
import id.co.telkomsigma.etc.cbo.integration.transaction.topic.StatusListTopicProducer;
import id.co.telkomsigma.etc.cbo.shared.data.StatusListContentDTO;
import id.co.telkomsigma.etc.cbo.shared.data.StatusListDTO;
import id.co.telkomsigma.tmf.service.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created on 12/14/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class BalanceInfoQueryListServiceImpl implements IBalanceInfoQueryListService {
    
    @Autowired
    private BalanceInfoListQueryClient balanceInfoListQueryClient;

    @Autowired
    private ISubscriberService subscriberService;

    @Autowired
    private ILogHitOtherService logHitOtherService;

    @Autowired
    private StatusListTopicProducer statusListTopicProducer;

    private static final Logger LOGGER = LoggerFactory.getLogger(BalanceInfoQueryListServiceImpl.class);

    @Override
    public void conductBI() {
        Date dateRequest = new Date();
        String errorResponse = "";
        BalanceInfoResponseDTO balanceInfoResponseDTO = balanceInfoListQueryClient.queryClient();
        if (balanceInfoResponseDTO != null) {
            if (balanceInfoResponseDTO.getBalanceInfoItems().size() > 0) {
                StatusListDTO statusListDTO = new StatusListDTO();
                List<StatusListContentDTO> statusListContentDTOs = new ArrayList<>();
                for (BalanceInfoItemDTO balanceInfoItemDTO : balanceInfoResponseDTO.getBalanceInfoItems()) {
                    Subscriber toUpdateSubscriber = subscriberService.findByServiceNo(balanceInfoItemDTO.getAccountId());
                    if (toUpdateSubscriber != null) {
                        toUpdateSubscriber.setLastBalance(toUpdateSubscriber.getCurrentBalance());
                        toUpdateSubscriber.setCurrentBalance(balanceInfoItemDTO.getBalanceAmount());
                        toUpdateSubscriber.setLastBalanceDate(toUpdateSubscriber.getModifiedOn());
                        try {
                            subscriberService.update(toUpdateSubscriber);
                        } catch (ServiceException e) {
                            errorResponse += e.getMessage();
                            LOGGER.error("Error updating subscriber data ".concat(e.toString()));
                        }
                        StatusListContentDTO statusListContentDTO = new StatusListContentDTO();
                        statusListContentDTO.setRecordType("1");
                        try {
                            statusListContentDTO.setPan(subscriberService.findPanByServiceNo(toUpdateSubscriber.getServiceNo()));
                        } catch (ServiceException e) {
                            statusListContentDTO.setPan(null);
                            LOGGER.error(e.toString());
                        }
                        statusListContentDTO.setBalance(String.valueOf(toUpdateSubscriber.getCurrentBalance()));
                        statusListContentDTO.setStatusFlags("0");
                        statusListContentDTOs.add(statusListContentDTO);
                    }
                }
                LogHitOther logHitOther = new LogHitOther();
                logHitOther.setLogDate(new Date());
                logHitOther.setFlagLog(CBOConstant.Query.FLAG_LOG_BI);
                logHitOther.setErrorResponse(errorResponse);
                logHitOther.setDateRequest(dateRequest);
                try {
                    logHitOtherService.insert(logHitOther);
                } catch (ServiceException e) {
                    e.printStackTrace();
                }
                statusListDTO.setContents(statusListContentDTOs);
                statusListTopicProducer.send(statusListDTO);
            }
        }
    }
}
