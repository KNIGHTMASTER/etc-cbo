package id.co.telkomsigma.etc.cbo.integration.transaction.service.impl;

import id.co.telkomsigma.etc.cbo.dao.IEventRatedDAO;
import id.co.telkomsigma.etc.cbo.data.model.EventRated;
import id.co.telkomsigma.etc.cbo.integration.transaction.service.IEventRatedService;
import id.co.telkomsigma.tmf.service.crud.ACrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created on 11/7/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class EventRatedServiceImpl extends ACrudService<EventRated> implements IEventRatedService {

    @Autowired
    private IEventRatedDAO eventRatedDAO;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingDAO = eventRatedDAO;
    }
}
