package id.co.telkomsigma.etc.cbo.data.dto.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created on 10/11/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
@ConfigurationProperties("api.cellum")
public class CellumAPI implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = 4178051692246732675L;

    String chargebatchstart;

    public String getChargebatchstart() {
        return chargebatchstart;
    }

    public void setChargebatchstart(String chargebatchstart) {
        this.chargebatchstart = chargebatchstart;
    }
}
