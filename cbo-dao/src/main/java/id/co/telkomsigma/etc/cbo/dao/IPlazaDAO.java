package id.co.telkomsigma.etc.cbo.dao;

import id.co.telkomsigma.etc.cbo.data.dto.param.PlazaNameParamDTO;
import id.co.telkomsigma.etc.cbo.data.model.Plaza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created on 10/11/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IPlazaDAO extends JpaRepository<Plaza, Integer> {

    @Query("SELECT new id.co.telkomsigma.etc.cbo.data.dto.param.PlazaNameParamDTO(p.plazaName) FROM Plaza p WHERE p.plazaCode = ?1")
    PlazaNameParamDTO findPlazaNameByPlazaCode(String p_PlazaCode);
}
