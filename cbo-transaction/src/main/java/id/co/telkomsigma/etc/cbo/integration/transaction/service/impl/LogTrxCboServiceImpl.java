package id.co.telkomsigma.etc.cbo.integration.transaction.service.impl;

import id.co.telkomsigma.etc.cbo.dao.ILogTrxCboDAO;
import id.co.telkomsigma.etc.cbo.data.model.LogTrxCBO;
import id.co.telkomsigma.etc.cbo.integration.transaction.service.ILogTrxCboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 10/11/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class LogTrxCboServiceImpl implements ILogTrxCboService {

    @Autowired
    ILogTrxCboDAO logTrxCboDAO;

    @Override
    public void insert(LogTrxCBO logTrxCBO) {
        logTrxCboDAO.save(logTrxCBO);
    }

}
