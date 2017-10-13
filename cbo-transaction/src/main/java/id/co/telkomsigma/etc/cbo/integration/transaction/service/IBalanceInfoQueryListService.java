package id.co.telkomsigma.etc.cbo.integration.transaction.service;

import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created on 10/13/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IBalanceInfoQueryListService {

    /**
     * <p>
     *     Insert into table log for Balance Info and Black List
     * </p>
     * @param p_ErrorResponse Error From Prev Process
     * @param p_FlagLog BI : Balance Info || BL : Black List
     * @param p_FlagStatus I : Insert || U : Update
     * @param p_IdLog Id to Update Prev Log
     * @return {@link java.lang.Long} last inserted Id
     */
    @Transactional
    Long insertLogBiAndBl(String p_ErrorResponse, String p_FlagLog, String p_FlagStatus, Long p_IdLog);

    /**
     * <p>
     *     Conduct Query List Process.
     * </p>
     */
    @Transactional
    void conduct();

    /**
     *
     * @param p_AccountId
     * @param p_BalanceAmount
     * @param p_BalanceQueriedAt
     */
    void insertStatusListBli(String p_AccountId, BigDecimal p_BalanceAmount, Date p_BalanceQueriedAt);

    /**
     * <p>
     *     Select number of existing E-Money in Subscriber
     * </p>
     * @return number of existing E-Money
     * @param p_EMoneyId Param E-Money Id
     */
    Integer selectExistingEMoney(String p_EMoneyId);
}
