package id.co.telkomsigma.etc.cbo.integration.transaction.service;

import id.co.telkomsigma.etc.cbo.data.model.ReferenceList;
import id.co.telkomsigma.tmf.service.crud.ICrudService;

import java.util.List;

/**
 * Created on 10/16/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IReferenceListService extends ICrudService<ReferenceList, Long> {

    List<ReferenceList> findByCode(String p_Code);
}
