package id.co.telkomsigma.etc.cbo.data.model;

import id.co.telkomsigma.tmf.data.model.base.ACrudDATA;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created on 9/28/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = "t_event_unrated", schema = "public")
public class EventUnRated extends ACrudDATA<Long> {

    private String pan;
    private String eMoneyId;
    private BigDecimal trxAmount;
    private String tbRowId;
    private Integer inputDataControlId;
    private Date timestampTr;
    private String dateTrx;
    private String resultCode;
    private String trxCmnId;

    @Column(name = "pan")
    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    @Column(name = "e_money_id")
    public String geteMoneyId() {
        return eMoneyId;
    }

    public void seteMoneyId(String eMoneyId) {
        this.eMoneyId = eMoneyId;
    }

    @Column(name = "trx_amount")
    public BigDecimal getTrxAmount() {
        return trxAmount;
    }

    public void setTrxAmount(BigDecimal trxAmount) {
        this.trxAmount = trxAmount;
    }

    @Column(name = "tb_rowid")
    public String getTbRowId() {
        return tbRowId;
    }

    public void setTbRowId(String tbRowId) {
        this.tbRowId = tbRowId;
    }

    public Integer getInputDataControlId() {
        return inputDataControlId;
    }

    @Column(name = "input_data_control_id")
    public void setInputDataControlId(Integer inputDataControlId) {
        this.inputDataControlId = inputDataControlId;
    }

    @Column(name = "time_stamp_tr")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getTimestampTr() {
        return timestampTr;
    }

    public void setTimestampTr(Date timestampTr) {
        this.timestampTr = timestampTr;
    }

    @Column(name = "datetrx")
    public String getDateTrx() {
        return dateTrx;
    }

    public void setDateTrx(String dateTrx) {
        this.dateTrx = dateTrx;
    }

    @Column(name = "result_code")
    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    @Column(name = "trx_cmn_id")
    public String getTrxCmnId() {
        return trxCmnId;
    }

    public void setTrxCmnId(String trxCmnId) {
        this.trxCmnId = trxCmnId;
    }

    @Override
    public String toString() {
        return "EventUnRated{" +
                "pan='" + pan + '\'' +
                ", eMoneyId='" + eMoneyId + '\'' +
                ", trxAmount=" + trxAmount +
                ", tbRowId='" + tbRowId + '\'' +
                ", inputDataControlId=" + inputDataControlId +
                ", timestampTr=" + timestampTr +
                ", dateTrx='" + dateTrx + '\'' +
                ", resultCode='" + resultCode + '\'' +
                ", trxCmnId='" + trxCmnId + '\'' +
                '}';
    }
}
