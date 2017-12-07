package id.co.telkomsigma.etc.cbo.integration.transaction.client;

import id.co.telkomsigma.etc.cbo.data.dto.request.querylist.RequestQueryListDTO;
import id.co.telkomsigma.etc.cbo.data.dto.response.ResponseChargeProcessStatusDTO;
import id.co.telkomsigma.tmf.integration.restclient.ARestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created on 10/13/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 *
 */
@Component
public class BalanceInfoListQueryV2Client extends ARestClient<ResponseChargeProcessStatusDTO, RequestQueryListDTO> {

    @Value("${api.mock.balanceinfo}")
    String mockBalanceInfo;

    @PostConstruct
    @Override
    public void init() {
        super.urlTarget = mockBalanceInfo;
    }


    @Override
    public Class<ResponseChargeProcessStatusDTO> getObjectResultClass() {
        return ResponseChargeProcessStatusDTO.class;
    }
}
