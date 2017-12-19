package id.co.telkomsigma.etc.cbo.integration.transaction.service;

import id.co.telkomsigma.etc.cbo.data.model.SubBlackList;
import id.co.telkomsigma.tmf.service.crud.ICrudService;

import java.util.List;

/**
 * Created on 12/18/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface ISubBlackListService extends ICrudService<SubBlackList, Long> {

    String findPanByEMoneyId(String p_EMoneyId);

    List<SubBlackList> findByObuIdAndSendStatus(String p_ObuId, String p_SendStatus);
}
