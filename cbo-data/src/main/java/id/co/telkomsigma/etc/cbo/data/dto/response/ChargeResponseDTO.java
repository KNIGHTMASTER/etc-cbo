package id.co.telkomsigma.etc.cbo.data.dto.response;

import java.io.Serializable;

/**
 * Created on 10/10/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class ChargeResponseDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = -6705244825224135352L;

    private String ResultCode;

    public String getResultCode() {
        return ResultCode;
    }

    public void setResultCode(String resultCode) {
        ResultCode = resultCode;
    }
}
