package id.co.telkomsigma.etc.cbo.shared.data;

import java.io.Serializable;
import java.util.List;

/**
 * Created on 10/19/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class StatusListDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = 1974505322852560418L;

    private List<StatusListContentDTO> contents;

    public List<StatusListContentDTO> getContents() {
        return contents;
    }

    public void setContents(List<StatusListContentDTO> contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        String result = "";
        for (StatusListContentDTO contentDTO : contents) {
            result += contentDTO.toString();
        }
        return result;
    }
}
