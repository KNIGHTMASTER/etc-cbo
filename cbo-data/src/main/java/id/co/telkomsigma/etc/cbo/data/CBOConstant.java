package id.co.telkomsigma.etc.cbo.data;

/**
 * Created on 9/28/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface CBOConstant {

    interface PackageScanner {
        interface Tmf {
            String COMPONENT_TMF = "id.co.telkomsigma.tmf";
            String ENTITY_TMF = "id.co.telkomsigma.tmf.data";
            String DAO_TMF = "id.co.telkomsigma.tmf.dao";
        }

        interface Cbo {
            String COMPONENT_CBO = "id.co.telkomsigma.etc.cbo";
            String ENTITY_CBO = "id.co.telkomsigma.etc.cbo.data";
            String DAO_CBO = "id.co.telkomsigma.etc.cbo.dao";
        }
    }

    interface BeanName {
        String QUEUE_ETC_TRANSACTION = "queue_etc_transaction";
    }

    interface Queue {
        String QUEUE_ETC_TRANSACTION = "queue.etc.transaction";
    }

    interface Query {
        String IS_HIT_NEW = "N";
    }

    interface TRX {
        String TB_ROWID = "TB_ROWID";
        String PAN = "PAN";
        String IDC_ID = "IDC_ID";
        String PLAZA_CODE = "PLAZA_CODE";
        String PLAZA_NAME = "PLAZA_NAME";
        String GATE_CODE = "GATE_CODE";
        String SHIFT_CODE = "SHIFT_CODE";
        String SHIFT_DATE = "SHIFT_DATE";
        String OBUTRXTIME = "OBUTRXTIME";
    }
}
