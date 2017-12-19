package id.co.telkomsigma.etc.cbo.data.dto.response.balanceinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import id.co.telkomsigma.etc.cbo.data.dto.response.querylist.BalanceInfoItemDTO;

import java.io.Serializable;
import java.util.List;

/**
 * Created on 12/14/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class BalanceInfoResponseDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = 923754437377609529L;

    @JsonProperty("BalanceInfoItems")
    private List<BalanceInfoItemDTO> balanceInfoItems;

    public List<BalanceInfoItemDTO> getBalanceInfoItems() {
        return balanceInfoItems;
    }

    public void setBalanceInfoItems(List<BalanceInfoItemDTO> balanceInfoItems) {
        this.balanceInfoItems = balanceInfoItems;
    }
}
