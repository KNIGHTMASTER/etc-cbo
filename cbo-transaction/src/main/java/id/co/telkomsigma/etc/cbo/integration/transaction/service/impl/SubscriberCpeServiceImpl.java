package id.co.telkomsigma.etc.cbo.integration.transaction.service.impl;

import id.co.telkomsigma.etc.cbo.dao.ISubscriberCpeDAO;
import id.co.telkomsigma.etc.cbo.data.model.SubscriberCpe;
import id.co.telkomsigma.etc.cbo.integration.transaction.service.ISubscriberCpeService;
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
public class SubscriberCpeServiceImpl extends AScaffoldingService<SubscriberCpe> implements ISubscriberCpeService {

    @Autowired
    ISubscriberCpeDAO subscriberCpeDAO;

    @PostConstruct
    @Override
    public void init() {
        super.scaffoldingDAO = subscriberCpeDAO;
    }
}
