package id.co.telkomsigma.etc.cbo.dao;

import id.co.telkomsigma.etc.cbo.data.model.StatusList;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 10/13/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IStatusListDAO extends JpaRepository<StatusList, Long> {
}
