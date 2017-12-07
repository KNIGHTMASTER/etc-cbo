package id.co.telkomsigma.etc.cbo.integration.transaction.service;

import id.co.telkomsigma.etc.cbo.data.model.EventRated;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created on 11/7/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IEventRatedService {

    @Transactional
    void insert(EventRated p_EventRated);
}
