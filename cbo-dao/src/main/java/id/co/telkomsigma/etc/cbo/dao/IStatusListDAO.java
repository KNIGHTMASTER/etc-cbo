package id.co.telkomsigma.etc.cbo.dao;

import id.co.telkomsigma.etc.cbo.data.model.StatusList;
import id.co.telkomsigma.tmf.dao.crud.ICrudDAO;
import org.springframework.data.jpa.repository.Query;

/**
 * Created on 10/13/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IStatusListDAO extends ICrudDAO<StatusList> {

    @Query(value = "SELECT COUNT (1) ttl FROM t_status_list a, subscriber b WHERE a.e_money_id = TRIM (b.service_no) ", nativeQuery = true)
    Long countStatusListByEMoneyAndFlagSourceAndIsWrite();
}
