package id.co.telkomsigma.etc.cbo.data.dto.response.balanceinfo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created on 10/13/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class BalanceInfoQueryListResponseDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = -2589395257306891876L;

    private BalanceInfoQueryListContentDTO data;
    private String error;

    @JsonProperty("data")
    public BalanceInfoQueryListContentDTO getData() {
        return data;
    }

    public void setData(BalanceInfoQueryListContentDTO data) {
        this.data = data;
    }

    @JsonProperty("error")
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
