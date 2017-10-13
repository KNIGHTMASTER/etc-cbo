package id.co.telkomsigma.etc.cbo.integration.transaction.service;

import id.co.telkomsigma.etc.cbo.data.model.LogHitOther;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created on 10/13/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface ILogHitOtherService {

    @Transactional
    @Modifying
    void update(LogHitOther p_LogHitOther);

    @Transactional
    void insert(LogHitOther p_LogHitOther);

    LogHitOther findById(Long p_Id);
}
