package id.co.telkomsigma.etc.cbo.data.dto.response;

import id.co.telkomsigma.tmf.data.dto.ResponseData;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created on 10/15/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class ResponseDataHateoas extends ResourceSupport {
    /**
     *
     *
     */
    private static final long serialVersionUID = -6360193327657831293L;
    private ResponseData responseData;

    public ResponseData getResponseData() {
        return responseData;
    }

    public void setResponseData(ResponseData responseData) {
        this.responseData = responseData;
    }
}
