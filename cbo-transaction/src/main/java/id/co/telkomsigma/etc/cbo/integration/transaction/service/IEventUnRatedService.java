package id.co.telkomsigma.etc.cbo.integration.transaction.service;

import id.co.telkomsigma.etc.cbo.data.model.EventUnRated;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created on 11/7/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IEventUnRatedService {

    @Transactional
    void insert(EventUnRated p_EventUnRated);
}
