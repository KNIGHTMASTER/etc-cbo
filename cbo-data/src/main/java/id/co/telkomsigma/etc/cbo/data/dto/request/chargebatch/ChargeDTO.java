package id.co.telkomsigma.etc.cbo.data.dto.request.chargebatch;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created on 10/10/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class ChargeDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = 2853905235097751973L;

    private BigDecimal Amount;
    private BigDecimal CommissionFee;
    private String Description;
    private List<ReferencesDTO> References;

    public BigDecimal getAmount() {
        return Amount;
    }

    public void setAmount(BigDecimal amount) {
        Amount = amount;
    }

    public BigDecimal getCommissionFee() {
        return CommissionFee;
    }

    public void setCommissionFee(BigDecimal commissionFee) {
        CommissionFee = commissionFee;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public List<ReferencesDTO> getReferences() {
        return References;
    }

    public void setReferences(List<ReferencesDTO> references) {
        References = references;
    }
}
