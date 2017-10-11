package id.co.telkomsigma.etc.cbo.data.dto.request.chargebatch;

import java.io.Serializable;
import java.util.List;

/**
 * Created on 10/10/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class ChargeRequestDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = 2732341288697756239L;

    private List<ChargeRequestContentDTO> ChargeRequests;

    public List<ChargeRequestContentDTO> getChargeRequests() {
        return ChargeRequests;
    }

    public void setChargeRequests(List<ChargeRequestContentDTO> chargeRequests) {
        ChargeRequests = chargeRequests;
    }
}
