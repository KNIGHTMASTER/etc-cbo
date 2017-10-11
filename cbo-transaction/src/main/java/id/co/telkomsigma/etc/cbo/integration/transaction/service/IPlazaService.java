package id.co.telkomsigma.etc.cbo.integration.transaction.service;

import id.co.telkomsigma.etc.cbo.data.dto.param.PlazaNameParamDTO;

/**
 * Created on 10/11/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IPlazaService {

    PlazaNameParamDTO findPlazaNameByPlazaCode(String p_PlazaCode);
}
