package id.co.telkomsigma.etc.cbo.integration.transaction;

/**
 * Created on 10/3/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface ICBOTransactionConstant {

    interface ApplicationContextName {
        String APPLICATION_CONTEXT_SCHEDULER = "application.context.scheduler";
    }

    interface Path {
        String CONDUCT_TRANSACTION = "/conduct";
    }

    interface TransactionCode {
        String TRX_EVENT_TYPE_ID = "118";
    }

    interface ReferenceListCode {
        String STATUS_LIST = "T_STATUS_LIST";
    }

    interface IsHitEventInput {
        String BATCH_START = "BS";
        String QUERY_LIST = "QL";
        String FAILED_CHARGE_BATCH = "FB";
    }

    interface JMS {

        interface ConnectionFactory {
            String TRX_CONNECTION_FACTORY = "jmsTrxListenerContainerFactory";
            String STATUS_LIST_TOPIC_CONNECTION_FACTORY = "jmsStatusListTopicConnectionFactory";
        }

        interface Queue {
            String QUEUE_TRX = "queue.trx";
        }

        interface Topic {
            String TOPIC_STATUS_LIST = "topic.status.list";
        }
    }

    interface Scheduler {
        interface Name {
            String SCHEDULER_QUERY_LIST = "schedulerQueryList";
        }

        interface TriggerName {
            String TRIGGER_QUERY_LIST = "triggerQueryList";
        }

        interface JobDetailName {
            String JOB_DETAIL_QUERY_LIST = "jobDetailQueryList";
        }
    }

}
