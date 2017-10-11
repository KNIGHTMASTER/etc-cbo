package id.co.telkomsigma.etc.cbo.data.dto.param;

import java.io.Serializable;

/**
 * Created on 10/11/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class PlazaNameParamDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = -1229475280090179208L;

    public PlazaNameParamDTO(String plazaName) {
        this.plazaName = plazaName;
    }

    private String plazaName;

    public String getPlazaName() {
        return plazaName;
    }

    public void setPlazaName(String plazaName) {
        this.plazaName = plazaName;
    }
}
