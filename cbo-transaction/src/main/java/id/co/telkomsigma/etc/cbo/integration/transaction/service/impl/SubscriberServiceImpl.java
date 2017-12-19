package id.co.telkomsigma.etc.cbo.integration.transaction.service.impl;

import id.co.telkomsigma.etc.cbo.dao.ISubscriberDAO;
import id.co.telkomsigma.etc.cbo.data.model.Subscriber;
import id.co.telkomsigma.etc.cbo.integration.transaction.service.ISubscriberService;
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
public class SubscriberServiceImpl extends AScaffoldingService<Subscriber> implements ISubscriberService {

    @Autowired
    ISubscriberDAO subscriberDAO;

    @PostConstruct
    @Override
    public void init() {
        super.scaffoldingDAO = subscriberDAO;
    }

    @Override
    public String findServiceNumberByPan(String p_Pan) {
        return subscriberDAO.getServiceNoByPan(p_Pan);
    }

    @Override
    public Long countByServiceNo(String p_ServiceNo) {
        return subscriberDAO.countByServiceNo(p_ServiceNo);
    }

    @Override
    public Subscriber findByServiceNo(String p_ServiceNo) {
        return subscriberDAO.findByServiceNo(p_ServiceNo);
    }

    @Override
    public String findPanByServiceNo(String p_ServiceNo) {
        return subscriberDAO.findPanByServiceNo(p_ServiceNo);
    }
}
