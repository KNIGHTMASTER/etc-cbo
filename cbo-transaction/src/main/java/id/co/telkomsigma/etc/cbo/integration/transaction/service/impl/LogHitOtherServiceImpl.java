package id.co.telkomsigma.etc.cbo.integration.transaction.service.impl;

import id.co.telkomsigma.etc.cbo.dao.ILogHitOtherDAO;
import id.co.telkomsigma.etc.cbo.data.model.LogHitOther;
import id.co.telkomsigma.etc.cbo.integration.transaction.service.ILogHitOtherService;
import id.co.telkomsigma.tmf.service.crud.ACrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created on 10/13/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class LogHitOtherServiceImpl extends ACrudService<LogHitOther> implements ILogHitOtherService {

    @Autowired
    ILogHitOtherDAO logHitOtherDAO;

    @PostConstruct
    @Override
    public void init() {
        super.scaffoldingDAO = logHitOtherDAO;
    }
}
