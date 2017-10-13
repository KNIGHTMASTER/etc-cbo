package id.co.telkomsigma.etc.cbo.integration.transaction.service.impl;

import id.co.telkomsigma.etc.cbo.dao.ILogHitOtherDAO;
import id.co.telkomsigma.etc.cbo.data.model.LogHitOther;
import id.co.telkomsigma.etc.cbo.integration.transaction.service.ILogHitOtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 10/13/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class LogHitOtherServiceImpl implements ILogHitOtherService {

    @Autowired
    ILogHitOtherDAO logHitOtherDAO;

    @Override
    public void update(LogHitOther p_LogHitOther) {

    }

    @Override
    public void insert(LogHitOther p_LogHitOther) {
        logHitOtherDAO.save(p_LogHitOther);
    }

    @Override
    public LogHitOther findById(Long p_Id) {
        return logHitOtherDAO.findOne(p_Id);
    }
}
