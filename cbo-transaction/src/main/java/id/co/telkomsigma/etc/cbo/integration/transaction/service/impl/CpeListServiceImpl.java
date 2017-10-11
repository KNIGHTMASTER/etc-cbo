package id.co.telkomsigma.etc.cbo.integration.transaction.service.impl;

import id.co.telkomsigma.etc.cbo.dao.ICpeListDAO;
import id.co.telkomsigma.etc.cbo.data.model.CpeList;
import id.co.telkomsigma.etc.cbo.integration.transaction.service.ICpeListService;
import id.co.telkomsigma.tmf.service.scaffolding.impl.AScaffoldingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created on 10/11/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class CpeListServiceImpl extends AScaffoldingService<CpeList> implements ICpeListService {

    @Autowired
    ICpeListDAO cpeListDAO;


    @PostConstruct
    @Override
    public void init() {
        super.scaffoldingDAO = cpeListDAO;
    }
}
