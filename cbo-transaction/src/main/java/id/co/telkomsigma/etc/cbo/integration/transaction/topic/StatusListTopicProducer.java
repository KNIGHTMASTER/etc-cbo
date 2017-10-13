package id.co.telkomsigma.etc.cbo.integration.transaction.topic;

import id.co.telkomsigma.etc.cbo.integration.transaction.ICBOTransactionConstant.JMS.Topic;
import id.co.telkomsigma.tmf.integration.messaging.IJMSProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

/**
 * Created on 10/12/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class StatusListTopicProducer implements IJMSProducer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Override
    public void send(Object o) {
        this.jmsMessagingTemplate.convertAndSend(Topic.TOPIC_STATUS_LIST, o);
    }
}
