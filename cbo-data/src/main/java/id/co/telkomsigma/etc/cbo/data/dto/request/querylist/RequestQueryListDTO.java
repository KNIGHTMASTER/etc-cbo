package id.co.telkomsigma.etc.cbo.data.dto.request.querylist;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created on 11/7/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class RequestQueryListDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = -3181680429942743540L;

    private List<String> externalIds;

    @JsonProperty("ExternalIds")
    public List<String> getExternalIds() {
        return externalIds;
    }

    public void setExternalIds(List<String> externalIds) {
        this.externalIds = externalIds;
    }
}
