package id.co.telkomsigma.etc.cbo.integration.transaction.queue;

import id.co.telkomsigma.etc.cbo.data.dto.EventInputDTO;
import id.co.telkomsigma.etc.cbo.data.model.LogTrxCBO;
import id.co.telkomsigma.etc.cbo.integration.transaction.ICBOTransactionConstant.JMS;
import id.co.telkomsigma.etc.cbo.integration.transaction.service.IETCTransactionService;
import id.co.telkomsigma.etc.cbo.integration.transaction.service.ILogTrxCboService;
import id.co.telkomsigma.tmf.integration.messaging.IJMSConsumer;
import id.co.telkomsigma.tmf.service.exception.ServiceException;
import id.co.telkomsigma.tmf.util.common.time.FormatDateConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Date;

import static id.co.telkomsigma.etc.cbo.integration.transaction.ICBOTransactionConstant.JMS.ConnectionFactory.TRX_CONNECTION_FACTORY;

/**
 * Created on 10/3/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class TransactionQueueConsumer implements IJMSConsumer<EventInputDTO> {

    @Autowired
    IETCTransactionService etcTransactionService;

    @Autowired
    ILogTrxCboService logTrxCboService;

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionQueueConsumer.class);

    @JmsListener(destination = JMS.Queue.QUEUE_TRX, containerFactory = TRX_CONNECTION_FACTORY)
    @Override
    public void receive(EventInputDTO eventInputDTO) {
//        LOGGER.info("MESSAGE RECEIVED "+eventInputDTO.toString());
        try {
            etcTransactionService.conductTransaction(eventInputDTO);
        } catch (ServiceException e) {
            LOGGER.error(e.toString());
        }
        insertLog(eventInputDTO);
    }

    private void insertLog(EventInputDTO eventInputDTO) {
        LogTrxCBO logTrxCBO = new LogTrxCBO();
        logTrxCBO.setCode(FormatDateConstant.ISO8601.format(eventInputDTO.getTimestampLog()));
        logTrxCBO.setLogDate(new Date());
        logTrxCBO.setRequestBody(eventInputDTO.toString());
        logTrxCBO.setDescription("Start insert into JMS Trx CBO");
        logTrxCBO.setStatus(1);

        logTrxCboService.insert(logTrxCBO);
    }

}
