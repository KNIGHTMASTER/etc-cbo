package id.co.telkomsigma.etc.cbo.dao;

import id.co.telkomsigma.etc.cbo.data.model.SubBlackList;
import id.co.telkomsigma.tmf.dao.crud.ICrudDAO;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created on 12/18/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface ISubBlackListDAO extends ICrudDAO<SubBlackList> {

    @Query(value = "SELECT pan from subscriber a, subscriber_cpe b, cpe_list c where a.id = b.id and b.id = c.id and a.e_money_id =?1 order by a.ACTIVE_DATE desc", nativeQuery = true)
    String findPanByEMoneyId(String p_EMoneyId);

    List<SubBlackList> findByObuIdAndSendStatus(String p_ObuId, String p_SendStatus);

}
