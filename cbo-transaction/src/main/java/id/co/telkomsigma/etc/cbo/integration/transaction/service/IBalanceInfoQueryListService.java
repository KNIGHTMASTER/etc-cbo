package id.co.telkomsigma.etc.cbo.integration.transaction.service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Created on 10/13/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IBalanceInfoQueryListService {

    @Transactional
    void conductBI();
}
