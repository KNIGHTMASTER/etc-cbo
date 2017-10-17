package id.co.telkomsigma.etc.cbo.integration.transaction.service.impl;

import id.co.telkomsigma.etc.cbo.dao.IEventInputDAO;
import id.co.telkomsigma.etc.cbo.data.model.EventInput;
import id.co.telkomsigma.etc.cbo.integration.transaction.service.IEventInputService;
import id.co.telkomsigma.tmf.service.scaffolding.impl.AScaffoldingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created on 10/3/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class EventInputServiceImpl extends AScaffoldingService<EventInput> implements IEventInputService {

    @Autowired
    IEventInputDAO eventInputDAO;

    @PostConstruct
    @Override
    public void init() {
        this.scaffoldingDAO = eventInputDAO;
    }

    @Override
    public List<EventInput> findByIsHit(String p_IsHit) {
        return eventInputDAO.findByIsHit(p_IsHit);
    }

    @Override
    public EventInput findByUuidInput(String p_UUID) {
        return eventInputDAO.findByUuidInput(p_UUID);
    }
}
