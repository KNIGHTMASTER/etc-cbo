package id.co.telkomsigma.etc.cbo.data.dto.request.blacklist;

import java.io.Serializable;

/**
 * Created on 12/18/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class RequestBlackListContentDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = -8894522051760174224L;

    private String eMoneyId;
    private String obuId;
    private String pSubscriptionStatusId;
    private String productId;
    private String dataId;
    private String transDate;
    private String blackListTypeId;
    private String reasonBl;

    public String geteMoneyId() {
        return eMoneyId;
    }

    public void seteMoneyId(String eMoneyId) {
        this.eMoneyId = eMoneyId;
    }

    public String getObuId() {
        return obuId;
    }

    public void setObuId(String obuId) {
        this.obuId = obuId;
    }

    public String getpSubscriptionStatusId() {
        return pSubscriptionStatusId;
    }

    public void setpSubscriptionStatusId(String pSubscriptionStatusId) {
        this.pSubscriptionStatusId = pSubscriptionStatusId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getTransDate() {
        return transDate;
    }

    public void setTransDate(String transDate) {
        this.transDate = transDate;
    }

    public String getBlackListTypeId() {
        return blackListTypeId;
    }

    public void setBlackListTypeId(String blackListTypeId) {
        this.blackListTypeId = blackListTypeId;
    }

    public String getReasonBl() {
        return reasonBl;
    }

    public void setReasonBl(String reasonBl) {
        this.reasonBl = reasonBl;
    }
}
