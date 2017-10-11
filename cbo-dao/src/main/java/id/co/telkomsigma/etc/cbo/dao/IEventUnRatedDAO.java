package id.co.telkomsigma.etc.cbo.dao;

import id.co.telkomsigma.etc.cbo.data.model.EventUnRated;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 10/10/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IEventUnRatedDAO extends JpaRepository<EventUnRated, Long>{
}
