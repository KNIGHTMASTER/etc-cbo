package id.co.telkomsigma.etc.cbo.integration.transaction.service.impl;

import id.co.telkomsigma.etc.cbo.dao.ILogTrxDAO;
import id.co.telkomsigma.etc.cbo.data.model.LogTrx;
import id.co.telkomsigma.etc.cbo.integration.transaction.service.ILogTrxService;
import id.co.telkomsigma.tmf.service.crud.ACrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created on 1/5/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class LogTrxServiceImpl extends ACrudService<LogTrx> implements ILogTrxService {

    @Autowired
    private ILogTrxDAO logTrxDAO;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingDAO = logTrxDAO;
    }
}
