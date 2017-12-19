package id.co.telkomsigma.etc.cbo.integration.transaction.client;

import id.co.telkomsigma.etc.cbo.data.dto.response.querylist.QueryListResponseDTO;
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
public class ListQueryClient extends ARestClient<QueryListResponseDTO, Object> {

    @Value("${api.cellum.balanceinfo}")
    String cellumQueryListAPI;

    @PostConstruct
    @Override
    public void init() {
        super.urlTarget = cellumQueryListAPI;
    }

    @Override
    public Class<QueryListResponseDTO> getObjectResultClass() {
        return QueryListResponseDTO.class;
    }

}
