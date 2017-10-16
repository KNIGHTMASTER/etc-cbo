package id.co.telkomsigma.etc.cbo.integration.transaction.service.impl;

import id.co.telkomsigma.etc.cbo.dao.IReferenceListDAO;
import id.co.telkomsigma.etc.cbo.data.model.ReferenceList;
import id.co.telkomsigma.etc.cbo.integration.transaction.service.IReferenceListService;
import id.co.telkomsigma.tmf.service.crud.ACrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created on 10/16/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class ReferenceListServiceImpl extends ACrudService<ReferenceList> implements IReferenceListService {

    @Autowired
    IReferenceListDAO referenceListDAO;

    @PostConstruct
    @Override
    public void init() {
        super.scaffoldingDAO = referenceListDAO;
    }

    @Override
    public List<ReferenceList> findByCode(String p_Code) {
        return referenceListDAO.findByCode(p_Code);
    }
}
