package id.co.telkomsigma.etc.cbo.integration.transaction.client;

import id.co.telkomsigma.etc.cbo.data.dto.response.balanceinfo.BalanceInfoResponseDTO;
import id.co.telkomsigma.tmf.integration.restclient.ARestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created on 12/14/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class BalanceInfoListQueryClient extends ARestClient<BalanceInfoResponseDTO, Object> {

    @Value("${api.cellum.balanceinfo}")
    private String balanceInfoUrl;

    @PostConstruct
    @Override
    public void init() {
        super.urlTarget = balanceInfoUrl;
    }

    @Override
    public Class<BalanceInfoResponseDTO> getObjectResultClass() {
        return BalanceInfoResponseDTO.class;
    }
}
