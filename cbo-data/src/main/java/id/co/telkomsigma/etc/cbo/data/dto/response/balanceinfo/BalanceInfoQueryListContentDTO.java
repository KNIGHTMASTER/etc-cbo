package id.co.telkomsigma.etc.cbo.data.dto.response.balanceinfo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created on 10/13/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class BalanceInfoQueryListContentDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = 1317518853552908593L;

    private List<BalanceInfoQueryListItemDTO> balanceInfoItems;

    @JsonProperty("BalanceInfoItems")
    public List<BalanceInfoQueryListItemDTO> getBalanceInfoItems() {
        return balanceInfoItems;
    }

    public void setBalanceInfoItems(List<BalanceInfoQueryListItemDTO> balanceInfoItems) {
        this.balanceInfoItems = balanceInfoItems;
    }
}
