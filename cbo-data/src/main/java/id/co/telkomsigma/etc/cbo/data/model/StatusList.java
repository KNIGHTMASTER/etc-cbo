package id.co.telkomsigma.etc.cbo.data.model;

import id.co.telkomsigma.tmf.data.model.base.ACrudDATA;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created on 10/13/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = "t_status_list", schema = "public")
public class StatusList extends ACrudDATA<Long> {
    private Date timestamp;
    private String productId;
    private String dataId;
    private String eMoneyId;
    private BigDecimal lastBalance;
    private BigDecimal topUpAmount;
    private Long transactionId;
    private String signature;
    private String isWrite;
    private Date hitTimeStamp;
    private Long inputDataControlId;
    private String rowIdInput;
    private String flagSource;
    private String fileName;
    private Integer fileSeq;
    private Date timeStampIc;

    @Column(name = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
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

    @Column(name = "e_money_id")
    public String geteMoneyId() {
        return eMoneyId;
    }

    public void seteMoneyId(String eMoneyId) {
        this.eMoneyId = eMoneyId;
    }

    @Column(name = "last_balance")
    public BigDecimal getLastBalance() {
        return lastBalance;
    }

    public void setLastBalance(BigDecimal lastBalance) {
        this.lastBalance = lastBalance;
    }

    @Column(name = "topup_amount")
    public BigDecimal getTopUpAmount() {
        return topUpAmount;
    }

    public void setTopUpAmount(BigDecimal topUpAmount) {
        this.topUpAmount = topUpAmount;
    }

    @Column(name = "transaction_id")
    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    @Column(name = "signature")
    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Column(name = "is_write")
    public String getIsWrite() {
        return isWrite;
    }

    public void setIsWrite(String isWrite) {
        this.isWrite = isWrite;
    }

    @Column(name = "hit_timestamp")
    public Date getHitTimeStamp() {
        return hitTimeStamp;
    }

    public void setHitTimeStamp(Date hitTimeStamp) {
        this.hitTimeStamp = hitTimeStamp;
    }

    @Column(name = "input_data_control_id")
    public Long getInputDataControlId() {
        return inputDataControlId;
    }

    public void setInputDataControlId(Long inputDataControlId) {
        this.inputDataControlId = inputDataControlId;
    }

    @Column(name = "rowid_input")
    public String getRowIdInput() {
        return rowIdInput;
    }

    public void setRowIdInput(String rowIdInput) {
        this.rowIdInput = rowIdInput;
    }

    @Column(name = "flag_source")
    public String getFlagSource() {
        return flagSource;
    }

    public void setFlagSource(String flagSource) {
        this.flagSource = flagSource;
    }

    @Column(name = "file_name")
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Column(name = "file_seq")
    public Integer getFileSeq() {
        return fileSeq;
    }

    public void setFileSeq(Integer fileSeq) {
        this.fileSeq = fileSeq;
    }

    @Column(name = "time_stamp_ic")
    public Date getTimeStampIc() {
        return timeStampIc;
    }

    public void setTimeStampIc(Date timeStampIc) {
        this.timeStampIc = timeStampIc;
    }
}
