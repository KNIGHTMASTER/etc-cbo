package id.co.telkomsigma.etc.cbo.data.dto.request.chargebatch;

import java.io.Serializable;

/**
 * Created on 10/10/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class ChargeRequestContentDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = 5725136936266880436L;

    private String ExternalId;
    private MerchantDTO Merchant;
    private UserDTO User;
    private ChargeDTO Charge;

    public String getExternalId() {
        return ExternalId;
    }

    public void setExternalId(String externalId) {
        ExternalId = externalId;
    }

    public MerchantDTO getMerchant() {
        return Merchant;
    }

    public void setMerchant(MerchantDTO merchant) {
        Merchant = merchant;
    }

    public UserDTO getUser() {
        return User;
    }

    public void setUser(UserDTO user) {
        User = user;
    }

    public ChargeDTO getCharge() {
        return Charge;
    }

    public void setCharge(ChargeDTO charge) {
        Charge = charge;
    }
}
