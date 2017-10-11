package id.co.telkomsigma.etc.cbo.integration.transaction.queue;

import id.co.telkomsigma.etc.cbo.data.dto.EventInputDTO;
import id.co.telkomsigma.etc.cbo.integration.transaction.ICBOTransactionConstant;
import id.co.telkomsigma.tmf.integration.messaging.IJMSProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * Created on 10/3/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class TransactionQueueProducer implements IJMSProducer<EventInputDTO> {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    @Qualifier(ICBOTransactionConstant.JMS.Queue.QUEUE_TRX)
    Queue queue;

    @Override
    public void send(EventInputDTO eventInputDTO) {
        this.jmsMessagingTemplate.convertAndSend(queue, eventInputDTO);
    }
}
