package id.co.telkomsigma.etc.cbo.data.dto.response.querylist;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created on 10/13/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class QueryListResponseDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = -2589395257306891876L;

    private QueryListContentDTO data;
    private String error;

    @JsonProperty("data")
    public QueryListContentDTO getData() {
        return data;
    }

    public void setData(QueryListContentDTO data) {
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
