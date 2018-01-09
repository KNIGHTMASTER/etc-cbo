package id.co.telkomsigma.etc.cbo.data.model;

import id.co.telkomsigma.tmf.data.model.base.ACrudDATA;

import javax.persistence.*;
import java.util.Date;

/**
 * Created on 9/28/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = "t_event_rated", schema = "public")
public class EventRated extends ACrudDATA<Long> {

    private Date timestamps;
    private String bankTrxId;
    private String referenceCode;
    private String wasRepeated;
    private String rowId;
    private Double inputDataControlId;
    private Date timestampProc;
    private String resultCode;
    private Double balanceInfo;
    private String startDateClm;
    private String transferDateClm;

    @Column(name = "timestamps")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getTimestamps() {
        return timestamps;
    }

    public void setTimestamps(Date timestamps) {
        this.timestamps = timestamps;
    }

    @Column(name = "bank_trxid")
    public String getBankTrxId() {
        return bankTrxId;
    }

    public void setBankTrxId(String bankTrxId) {
        this.bankTrxId = bankTrxId;
    }

    @Column(name = "reference_code")
    public String getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }

    @Column(name = "wasrepeated")
    public String getWasRepeated() {
        return wasRepeated;
    }

    public void setWasRepeated(String wasRepeated) {
        this.wasRepeated = wasRepeated;
    }

    @Column(name = "row_id")
    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    @Column(name = "input_data_control_id")
    public Double getInputDataControlId() {
        return inputDataControlId;
    }

    public void setInputDataControlId(Double inputDataControlId) {
        this.inputDataControlId = inputDataControlId;
    }

    @Column(name = "timestamp_proc")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getTimestampProc() {
        return timestampProc;
    }

    public void setTimestampProc(Date timestampProc) {
        this.timestampProc = timestampProc;
    }

    @Column(name = "result_code")
    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    @Column(name = "balanceinfo")
    public Double getBalanceInfo() {
        return balanceInfo;
    }

    public void setBalanceInfo(Double balanceInfo) {
        this.balanceInfo = balanceInfo;
    }

    @Column(name = "startdate_clm")
    public String getStartDateClm() {
        return startDateClm;
    }

    public void setStartDateClm(String startDateClm) {
        this.startDateClm = startDateClm;
    }

    @Column(name = "transferdate_clm")
    public String getTransferDateClm() {
        return transferDateClm;
    }

    public void setTransferDateClm(String transferDateClm) {
        this.transferDateClm = transferDateClm;
    }
}
