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
        String BLACKLIST = "/blacklist";
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
            String BLACK_LIST_TOPIC_CONNECTION_FACTORY = "jmsBlackListTopicConnectionFactory";
        }

        interface Queue {
            String QUEUE_TRX = "queue.trx";
        }

        interface Topic {
            String TOPIC_STATUS_LIST = "topic.status.list";
            String TOPIC_BLACK_LIST = "topic.black.list";
        }
    }

    interface Scheduler {
        interface Name {
            String SCHEDULER_QUERY_LIST = "schedulerQueryList";
            String SCHEDULER_BALANCE_INFO = "schedulerBalanceInfo";
        }

        interface TriggerName {
            String TRIGGER_QUERY_LIST = "triggerQueryList";
            String TRIGGER_BALANCE_INFO = "triggerBalanceInfo";
        }

        interface JobDetailName {
            String JOB_DETAIL_QUERY_LIST = "jobDetailQueryList";
            String JOB_DETAIL_BALANCE_INFO = "jobDetailBalanceInfo";
        }
    }

}
