package id.co.telkomsigma.etc.cbo.integration.transaction.service.impl;

import id.co.telkomsigma.etc.cbo.dao.IEventRatedDAO;
import id.co.telkomsigma.etc.cbo.data.model.EventRated;
import id.co.telkomsigma.etc.cbo.integration.transaction.service.IEventRatedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 11/7/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class EventRatedServiceImpl implements IEventRatedService {

    @Autowired
    private IEventRatedDAO eventRatedDAO;

    @Override
    public void insert(EventRated p_EventRated) {
        eventRatedDAO.save(p_EventRated);
    }
}
