package id.co.telkomsigma.etc.cbo.integration.transaction.service.impl;

import id.co.telkomsigma.etc.cbo.dao.IEventUnRatedDAO;
import id.co.telkomsigma.etc.cbo.data.model.EventUnRated;
import id.co.telkomsigma.etc.cbo.integration.transaction.service.IEventUnRatedService;
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
public class EventUnRatedServiceImpl extends ACrudService<EventUnRated> implements IEventUnRatedService {

    @Autowired
    private IEventUnRatedDAO eventUnRatedDAO;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingDAO = eventUnRatedDAO;
    }
}
