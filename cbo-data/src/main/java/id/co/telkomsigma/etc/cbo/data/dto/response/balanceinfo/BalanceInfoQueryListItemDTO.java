package id.co.telkomsigma.etc.cbo.data.dto.response.balanceinfo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created on 10/13/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class BalanceInfoQueryListItemDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = -2077487411342937311L;

    private String accountId;
    private BigDecimal balanceAmount;
    private Date balanceQueriedAt;

    @JsonProperty("AccountId")
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @JsonProperty("BalanceAmount")
    public BigDecimal getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(BigDecimal balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    @JsonProperty("BalanceQueriedAt")
    public Date getBalanceQueriedAt() {
        return balanceQueriedAt;
    }

    public void setBalanceQueriedAt(Date balanceQueriedAt) {
        this.balanceQueriedAt = balanceQueriedAt;
    }
}
