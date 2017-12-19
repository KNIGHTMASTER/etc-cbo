package id.co.telkomsigma.etc.cbo.integration.transaction.service.impl;

import id.co.telkomsigma.etc.cbo.dao.ISubBlackListDAO;
import id.co.telkomsigma.etc.cbo.data.model.SubBlackList;
import id.co.telkomsigma.etc.cbo.integration.transaction.service.ISubBlackListService;
import id.co.telkomsigma.tmf.service.crud.ACrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created on 12/18/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class SubBackListServiceImpl extends ACrudService<SubBlackList> implements ISubBlackListService {

    @Autowired
    private ISubBlackListDAO subBlackListDAO;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingDAO = subBlackListDAO;
    }

    @Override
    public String findPanByEMoneyId(String p_EMoneyId) {
        return subBlackListDAO.findPanByEMoneyId(p_EMoneyId);
    }

    @Override
    public List<SubBlackList> findByObuIdAndSendStatus(String p_ObuId, String p_SendStatus) {
        return subBlackListDAO.findByObuIdAndSendStatus(p_ObuId, p_SendStatus);
    }
}
