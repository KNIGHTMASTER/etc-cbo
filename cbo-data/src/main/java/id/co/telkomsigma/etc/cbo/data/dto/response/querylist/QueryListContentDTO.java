package id.co.telkomsigma.etc.cbo.data.dto.response.querylist;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created on 10/13/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class QueryListContentDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = 1317518853552908593L;

    private List<BalanceInfoItemDTO> balanceInfoItems;

    @JsonProperty("BalanceInfoItems")
    public List<BalanceInfoItemDTO> getBalanceInfoItems() {
        return balanceInfoItems;
    }

    public void setBalanceInfoItems(List<BalanceInfoItemDTO> balanceInfoItems) {
        this.balanceInfoItems = balanceInfoItems;
    }
}
