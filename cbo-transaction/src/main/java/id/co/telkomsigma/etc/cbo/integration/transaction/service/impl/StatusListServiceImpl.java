package id.co.telkomsigma.etc.cbo.integration.transaction.service.impl;

import id.co.telkomsigma.etc.cbo.dao.IStatusListDAO;
import id.co.telkomsigma.etc.cbo.data.model.StatusList;
import id.co.telkomsigma.etc.cbo.integration.transaction.service.IStatusListService;
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
public class StatusListServiceImpl extends ACrudService<StatusList> implements IStatusListService {
    @Autowired
    IStatusListDAO statusListDAO;

    @PostConstruct
    @Override
    public void init() {
        super.scaffoldingDAO = statusListDAO;
    }

    @Override
    public Long countStatusListByEMoneyAndFlagSourceAndIsWrite() {
        return statusListDAO.countStatusListByEMoneyAndFlagSourceAndIsWrite();
    }

    @Override
    public Long countStatusListByEMoneyAndFlagSourceAndIsWriteAndInputDataControl() {
        return statusListDAO.countStatusListByEMoneyAndFlagSourceAndIsWriteAndInputDataControl();
    }
}
