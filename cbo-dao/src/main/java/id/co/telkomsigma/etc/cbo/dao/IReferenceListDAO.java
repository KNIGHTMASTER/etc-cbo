package id.co.telkomsigma.etc.cbo.dao;

import id.co.telkomsigma.etc.cbo.data.model.ReferenceList;
import id.co.telkomsigma.tmf.dao.crud.ICrudDAO;

import java.util.List;

/**
 * Created on 10/16/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IReferenceListDAO extends ICrudDAO<ReferenceList> {

    List<ReferenceList> findByCode(String p_Code);
}
