package id.co.telkomsigma.etc.cbo.data.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created on 11/7/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class ResponseChargeProcessStatusDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = 368564981782649032L;

    private List<ChargeProsesStatusContentDTO> chargeProcessStatuses;

    @JsonProperty("ChargeProcessStatuses")
    public List<ChargeProsesStatusContentDTO> getChargeProcessStatuses() {
        return chargeProcessStatuses;
    }

    public void setChargeProcessStatuses(List<ChargeProsesStatusContentDTO> chargeProcessStatuses) {
        this.chargeProcessStatuses = chargeProcessStatuses;
    }
}
