package id.co.telkomsigma.etc.cbo.dao;

import id.co.telkomsigma.etc.cbo.data.model.Subscriber;
import id.co.telkomsigma.tmf.dao.scaffolding.IScaffoldingDAO;
import org.springframework.data.jpa.repository.Query;

/**
 * Created on 10/10/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface ISubscriberDAO extends IScaffoldingDAO<Subscriber> {

    @Query(value = "SELECT service_no from subscriber a, subscriber_cpe b, cpe_list c where a.id = b.id and b.id = c.id and c.pan =?1 order by a.ACTIVE_DATE desc", nativeQuery = true)
    String getServiceNoByPan(String p_Pan);

    @Query(value = "SELECT COUNT(s) FROM Subscriber s where s.serviceNo = ?1")
    Long countByServiceNo(String p_ServiceNo);
}
