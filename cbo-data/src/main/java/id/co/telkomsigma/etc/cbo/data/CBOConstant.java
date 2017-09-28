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

}
