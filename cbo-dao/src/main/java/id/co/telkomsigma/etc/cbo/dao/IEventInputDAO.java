package id.co.telkomsigma.etc.cbo.dao;

import id.co.telkomsigma.etc.cbo.data.model.EventInput;
import id.co.telkomsigma.tmf.dao.scaffolding.IScaffoldingDAO;

import java.util.List;

/**
 * Created on 10/3/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IEventInputDAO extends IScaffoldingDAO<EventInput> {

    List<EventInput> findByIsHit(String p_IsHit);

    EventInput findByUuidInput(String p_UUID);
}
