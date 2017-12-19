package id.co.telkomsigma.etc.cbo.data.dto.request.blacklist;

import java.io.Serializable;
import java.util.List;

/**
 * Created on 12/18/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class RequestBlackListDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = -7278882063010677906L;

    private List<RequestBlackListContentDTO> blackListContent;

    public List<RequestBlackListContentDTO> getBlackListContent() {
        return blackListContent;
    }

    public void setBlackListContent(List<RequestBlackListContentDTO> blackListContent) {
        this.blackListContent = blackListContent;
    }
}
