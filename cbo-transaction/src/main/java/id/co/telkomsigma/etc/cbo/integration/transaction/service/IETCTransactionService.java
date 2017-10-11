package id.co.telkomsigma.etc.cbo.integration.transaction.service;

import id.co.telkomsigma.etc.cbo.data.dto.EventInputDTO;
import id.co.telkomsigma.tmf.service.exception.ServiceException;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created on 10/4/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IETCTransactionService {

    @Transactional()
    void conductTransaction(EventInputDTO p_EventInputDTO) throws ServiceException;

    void insertEventInput(EventInputDTO p_EventInputDTO) throws ServiceException;

    void hitChargeBatchStartAPI();
}
