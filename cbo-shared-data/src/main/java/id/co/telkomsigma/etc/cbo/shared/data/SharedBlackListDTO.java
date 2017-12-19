package id.co.telkomsigma.etc.cbo.shared.data;

import java.io.Serializable;
import java.util.List;

/**
 * Created on 12/18/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class SharedBlackListDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = 3557963002286019056L;

    private List<BlackListContentDTO> blackListContentDTOs;

    public List<BlackListContentDTO> getBlackListContentDTOs() {
        return blackListContentDTOs;
    }

    public void setBlackListContentDTOs(List<BlackListContentDTO> blackListContentDTOs) {
        this.blackListContentDTOs = blackListContentDTOs;
    }

    @Override
    public String toString() {
        String result = "";
        for (BlackListContentDTO blackListContentDTO : blackListContentDTOs) {
            result += blackListContentDTO.toString();
        }
        return result;
    }
}
