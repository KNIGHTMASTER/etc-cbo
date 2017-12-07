package id.co.telkomsigma.etc.cbo.integration.transaction.service.impl;

import id.co.telkomsigma.etc.cbo.dao.IEventUnRatedDAO;
import id.co.telkomsigma.etc.cbo.data.model.EventUnRated;
import id.co.telkomsigma.etc.cbo.integration.transaction.service.IEventUnRatedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 11/7/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class EventUnRatedServiceImpl implements IEventUnRatedService {

    @Autowired
    private IEventUnRatedDAO eventUnRatedDAO;

    @Override
    public void insert(EventUnRated p_EventUnRated) {
        eventUnRatedDAO.save(p_EventUnRated);
    }
}
