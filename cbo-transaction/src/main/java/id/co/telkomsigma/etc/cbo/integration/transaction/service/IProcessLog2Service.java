package id.co.telkomsigma.etc.cbo.integration.transaction.service;

import id.co.telkomsigma.etc.cbo.data.model.ProcessLog2;
import id.co.telkomsigma.tmf.service.crud.ICrudService;
import id.co.telkomsigma.tmf.service.exception.ServiceException;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created on 10/16/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IProcessLog2Service extends ICrudService<ProcessLog2, Long> {

    @Transactional
    void writeMessage(Integer p_ControlTableId, String p_LogMessage, String p_Val1, String p_Val2, String p_Val3, String p_Val4) throws ServiceException ;
}
