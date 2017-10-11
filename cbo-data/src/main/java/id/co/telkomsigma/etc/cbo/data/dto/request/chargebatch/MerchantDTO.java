package id.co.telkomsigma.etc.cbo.data.dto.request.chargebatch;

import java.io.Serializable;

/**
 * Created on 10/10/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class MerchantDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = 7081059711780574573L;

    private int MerchantId;
    private int TerminalId;

    public int getMerchantId() {
        return MerchantId;
    }

    public void setMerchantId(int merchantId) {
        MerchantId = merchantId;
    }

    public int getTerminalId() {
        return TerminalId;
    }

    public void setTerminalId(int terminalId) {
        TerminalId = terminalId;
    }
}
