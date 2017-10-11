package id.co.telkomsigma.etc.cbo.integration.transaction.service.impl;

import id.co.telkomsigma.etc.cbo.dao.IPlazaDAO;
import id.co.telkomsigma.etc.cbo.data.dto.param.PlazaNameParamDTO;
import id.co.telkomsigma.etc.cbo.integration.transaction.service.IPlazaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 10/11/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class PlazaServiceImpl implements IPlazaService {

    @Autowired
    IPlazaDAO plazaDAO;

    @Override
    public PlazaNameParamDTO findPlazaNameByPlazaCode(String p_PlazaCode) {
        return plazaDAO.findPlazaNameByPlazaCode(p_PlazaCode);
    }
}
