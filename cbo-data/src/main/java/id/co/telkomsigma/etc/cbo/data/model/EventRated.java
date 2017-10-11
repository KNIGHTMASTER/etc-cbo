package id.co.telkomsigma.etc.cbo.data.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created on 9/28/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = "t_event_rated", schema = "public")
public class EventRated {

    @Id
    @Column(name = "timestamps")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamps;

    @Column(name = "bank_trxid")
    private String bankTrxId;

    @Column(name = "reference_code")
    private String referenceCode;

    @Column(name = "wasrepeated")
    private String wasRepeated;

    @Column(name = "row_id")
    private String rowId;

    @Column(name = "input_data_control_id")
    private Double inputDataControlId;

    @Column(name = "timestamp_proc")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestampProc;

    @Column(name = "result_code")
    private String resultCode;

    @Column(name = "balanceinfo")
    private Double balanceInfo;

    @Column(name = "startdate_clm")
    private String startDateClm;

    @Column(name = "transferdate_clm")
    private String transferDateClm;

    public Date getTimestamps() {
        return timestamps;
    }

    public void setTimestamps(Date timestamps) {
        this.timestamps = timestamps;
    }

    public String getBankTrxId() {
        return bankTrxId;
    }

    public void setBankTrxId(String bankTrxId) {
        this.bankTrxId = bankTrxId;
    }

    public String getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }

    public String getWasRepeated() {
        return wasRepeated;
    }

    public void setWasRepeated(String wasRepeated) {
        this.wasRepeated = wasRepeated;
    }

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public Double getInputDataControlId() {
        return inputDataControlId;
    }

    public void setInputDataControlId(Double inputDataControlId) {
        this.inputDataControlId = inputDataControlId;
    }

    public Date getTimestampProc() {
        return timestampProc;
    }

    public void setTimestampProc(Date timestampProc) {
        this.timestampProc = timestampProc;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public Double getBalanceInfo() {
        return balanceInfo;
    }

    public void setBalanceInfo(Double balanceInfo) {
        this.balanceInfo = balanceInfo;
    }

    public String getStartDateClm() {
        return startDateClm;
    }

    public void setStartDateClm(String startDateClm) {
        this.startDateClm = startDateClm;
    }

    public String getTransferDateClm() {
        return transferDateClm;
    }

    public void setTransferDateClm(String transferDateClm) {
        this.transferDateClm = transferDateClm;
    }
}
