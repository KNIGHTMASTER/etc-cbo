package id.co.telkomsigma.etc.cbo.integration.transaction.service.impl;

import id.co.telkomsigma.etc.cbo.dao.IProcessLog2DAO;
import id.co.telkomsigma.etc.cbo.data.model.ProcessLog2;
import id.co.telkomsigma.etc.cbo.integration.transaction.service.IProcessLog2Service;
import id.co.telkomsigma.tmf.service.crud.ACrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;

/**
 * Created on 10/16/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class ProcessLog2ServiceImpl extends ACrudService<ProcessLog2> implements IProcessLog2Service {

    @Autowired
    IProcessLog2DAO processLog2DAO;

    @PostConstruct
    @Override
    public void init() {
        super.scaffoldingDAO = processLog2DAO;
    }

    @Override
    public void writeMessage(Integer p_ControlTableId, String p_LogMessage, String p_Val1, String p_Val2, String p_Val3, String p_Val4) {
        ProcessLog2 processLog2 = new ProcessLog2();
        processLog2.setControlTableId(p_ControlTableId);
        processLog2.setLogDate(new Date());
        processLog2.setLogMessage(p_LogMessage.substring(1, 500));
        processLog2.setVal1(p_Val1.substring(1, 32));
        processLog2.setVal2(p_Val2.substring(1, 32));
        processLog2.setVal3(p_Val3.substring(1, 64));
        processLog2.setVal4(p_Val4.substring(1, 64));
        processLog2DAO.save(processLog2);
    }
}
