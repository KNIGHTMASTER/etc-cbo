package id.co.telkomsigma.etc.cbo.dao;

import id.co.telkomsigma.etc.cbo.data.model.LogTrxCBO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 10/11/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface ILogTrxCboDAO extends JpaRepository<LogTrxCBO, Long> {
}
