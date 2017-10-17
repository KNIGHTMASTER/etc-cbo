package id.co.telkomsigma.etc.cbo.integration.transaction.service;

import id.co.telkomsigma.etc.cbo.data.dto.EventInputDTO;
import id.co.telkomsigma.etc.cbo.data.dto.request.chargebatch.ChargeRequestContentDTO;
import id.co.telkomsigma.etc.cbo.data.dto.request.chargebatch.ChargeRequestDTO;
import id.co.telkomsigma.etc.cbo.data.model.EventInput;
import id.co.telkomsigma.tmf.service.exception.ServiceException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created on 10/4/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IETCTransactionService {

    @Transactional()
    void conductTransaction(EventInputDTO p_EventInputDTO) throws ServiceException;

    void insertEventInput(EventInputDTO p_EventInputDTO) throws ServiceException;

    /**
     * Run Hit Chage in Bulk Mode
     */
    void hitChargeBatchStartAPI();

    /**
     * Run Hit Charge 1 By 1
     * @param p_Id
     */
    void hitChargeBatchStartAPI(String p_Id);

    ChargeRequestDTO buildRequestHitCharge(List<EventInput> p_EventInputList);

    ChargeRequestContentDTO buildContentRequestHitCharge(EventInput p_EventInput);

    void runRestClient(ChargeRequestDTO p_ChargeRequestDTO);
}
