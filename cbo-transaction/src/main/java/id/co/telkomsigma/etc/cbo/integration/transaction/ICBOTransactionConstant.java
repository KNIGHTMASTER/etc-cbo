package id.co.telkomsigma.etc.cbo.integration.transaction;

/**
 * Created on 10/3/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface ICBOTransactionConstant {

    interface Path {
        String CONDUCT_TRANSACTION = "/conduct";
    }

    interface TransactionCode {
        String TRX_EVENT_TYPE_ID = "118";
    }

    interface JMS {
        interface ConnectionFactory {
            String TRX_CONNECTION_FACTORY = "jmsTrxListenerContainerFactory";
        }
        interface Queue {
            String QUEUE_TRX = "queue.trx";
        }
    }

}
