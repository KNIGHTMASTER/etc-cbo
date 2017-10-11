package id.co.telkomsigma.etc.cbo.integration.transaction.client;

import id.co.telkomsigma.etc.cbo.data.dto.request.chargebatch.ChargeRequestDTO;
import id.co.telkomsigma.etc.cbo.data.dto.response.ChargeResponseDTO;
import id.co.telkomsigma.tmf.integration.restclient.ARestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created on 10/3/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class ChargeBatchStartClient extends ARestClient<ChargeResponseDTO, ChargeRequestDTO> {

    @Value("${api.cellum.chargebatchstart}")
    String apiCellumChargeBatchStart;

    @PostConstruct
    @Override
    public void init() {
        super.urlTarget = apiCellumChargeBatchStart;
    }

    @Override
    public Class<ChargeResponseDTO> getObjectResultClass() {
        return ChargeResponseDTO.class;
    }
}
