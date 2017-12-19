package id.co.telkomsigma.etc.cbo.data.model;

import id.co.telkomsigma.tmf.data.model.base.ACrudDATA;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created on 12/18/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = "t_subs_black_list")
public class SubBlackList extends ACrudDATA<Long> {

    private String eMoneyId;
    private String obuId;
    private Integer pSubscribtionStatusId;
    private String productId;
    private String dataId;
    private BigDecimal lastBalance;
    private BigDecimal topupAmount;
    private Integer transactionId;
    private String sendStatus;
    private Date transDate;
    private String blackListTypeId;
    private String blackListSource;
    private Integer fileSeq;
    private Date timeStampIc;
    private Date blackListDateTime;
    private String reasonBl;

    @Column(name = "emoney_id")
    public String geteMoneyId() {
        return eMoneyId;
    }

    public void seteMoneyId(String eMoneyId) {
        this.eMoneyId = eMoneyId;
    }

    @Column(name = "obu_id")
    public String getObuId() {
        return obuId;
    }

    public void setObuId(String obuId) {
        this.obuId = obuId;
    }

    @Column(name = "p_subscription_status_id")
    public Integer getpSubscribtionStatusId() {
        return pSubscribtionStatusId;
    }

    public void setpSubscribtionStatusId(Integer pSubscribtionStatusId) {
        this.pSubscribtionStatusId = pSubscribtionStatusId;
    }

    @Column(name = "product_id")
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Column(name = "data_id")
    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    @Column(name = "last_balance")
    public BigDecimal getLastBalance() {
        return lastBalance;
    }

    public void setLastBalance(BigDecimal lastBalance) {
        this.lastBalance = lastBalance;
    }

    @Column(name = "topup_amount")
    public BigDecimal getTopupAmount() {
        return topupAmount;
    }

    public void setTopupAmount(BigDecimal topupAmount) {
        this.topupAmount = topupAmount;
    }

    @Column(name = "transaction_id")
    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    @Column(name = "send_status")
    public String getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(String sendStatus) {
        this.sendStatus = sendStatus;
    }

    @Column(name = "trans_date")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    @Column(name = "black_list_type_id")
    public String getBlackListTypeId() {
        return blackListTypeId;
    }

    public void setBlackListTypeId(String blackListTypeId) {
        this.blackListTypeId = blackListTypeId;
    }

    @Column(name = "black_list_source")
    public String getBlackListSource() {
        return blackListSource;
    }

    public void setBlackListSource(String blackListSource) {
        this.blackListSource = blackListSource;
    }

    @Column(name = "file_seq")
    public Integer getFileSeq() {
        return fileSeq;
    }

    public void setFileSeq(Integer fileSeq) {
        this.fileSeq = fileSeq;
    }

    @Column(name = "time_stamp_ic")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getTimeStampIc() {
        return timeStampIc;
    }

    public void setTimeStampIc(Date timeStampIc) {
        this.timeStampIc = timeStampIc;
    }

    @Column(name = "blacklist_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getBlackListDateTime() {
        return blackListDateTime;
    }

    public void setBlackListDateTime(Date blackListDateTime) {
        this.blackListDateTime = blackListDateTime;
    }

    @Column(name = "reason_bl")
    public String getReasonBl() {
        return reasonBl;
    }

    public void setReasonBl(String reasonBl) {
        this.reasonBl = reasonBl;
    }
}
