package id.co.telkomsigma.etc.cbo.integration.transaction.service;

import id.co.telkomsigma.etc.cbo.data.model.LogTrxCBO;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created on 10/11/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface ILogTrxCboService {

    @Transactional
    void insert(LogTrxCBO logTrxCBO);
}
