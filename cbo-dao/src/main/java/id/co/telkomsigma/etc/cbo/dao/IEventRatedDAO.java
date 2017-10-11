package id.co.telkomsigma.etc.cbo.dao;

import id.co.telkomsigma.etc.cbo.data.model.EventRated;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

/**
 * Created on 10/10/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IEventRatedDAO extends JpaRepository<EventRated, Date> {
}
