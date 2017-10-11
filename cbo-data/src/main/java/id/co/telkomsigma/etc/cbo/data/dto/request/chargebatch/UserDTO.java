package id.co.telkomsigma.etc.cbo.data.dto.request.chargebatch;

import java.io.Serializable;

/**
 * Created on 10/10/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class UserDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = -6609645127174510949L;

    private String AccountId;
    private int AppTypeId;

    public String getAccountId() {
        return AccountId;
    }

    public void setAccountId(String accountId) {
        AccountId = accountId;
    }

    public int getAppTypeId() {
        return AppTypeId;
    }

    public void setAppTypeId(int appTypeId) {
        AppTypeId = appTypeId;
    }
}
