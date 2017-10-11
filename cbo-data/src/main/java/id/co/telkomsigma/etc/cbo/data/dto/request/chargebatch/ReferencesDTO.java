package id.co.telkomsigma.etc.cbo.data.dto.request.chargebatch;

import java.io.Serializable;

/**
 * Created on 10/11/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class ReferencesDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = 2612281412425320026L;

    private String key;
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
