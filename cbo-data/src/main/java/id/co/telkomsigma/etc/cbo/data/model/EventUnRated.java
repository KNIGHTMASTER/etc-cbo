package id.co.telkomsigma.etc.cbo.data.model;

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
public class EventUnRated {

    @Id
    @Column(name = "pan")
    private String pan;

    @Column(name = "e_money_id")
    private String eMoneyId;

    @Column(name = "trx_amount")
    private BigDecimal trxAmount;

    @Column(name = "tb_rowid")
    private String tbRowId;

    @Column(name = "input_data_control_id")
    private String inputDataControlId;

    @Column(name = "time_stamp_tr")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestampTr;

    @Column(name = "datetrx")
    private String dateTrx;

    @Column(name = "result_code")
    private String resultCode;

    @Column(name = "trx_cmn_id")
    private String trxCmnId;

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String geteMoneyId() {
        return eMoneyId;
    }

    public void seteMoneyId(String eMoneyId) {
        this.eMoneyId = eMoneyId;
    }

    public BigDecimal getTrxAmount() {
        return trxAmount;
    }

    public void setTrxAmount(BigDecimal trxAmount) {
        this.trxAmount = trxAmount;
    }

    public String getTbRowId() {
        return tbRowId;
    }

    public void setTbRowId(String tbRowId) {
        this.tbRowId = tbRowId;
    }

    public String getInputDataControlId() {
        return inputDataControlId;
    }

    public void setInputDataControlId(String inputDataControlId) {
        this.inputDataControlId = inputDataControlId;
    }

    public Date getTimestampTr() {
        return timestampTr;
    }

    public void setTimestampTr(Date timestampTr) {
        this.timestampTr = timestampTr;
    }

    public String getDateTrx() {
        return dateTrx;
    }

    public void setDateTrx(String dateTrx) {
        this.dateTrx = dateTrx;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getTrxCmnId() {
        return trxCmnId;
    }

    public void setTrxCmnId(String trxCmnId) {
        this.trxCmnId = trxCmnId;
    }
}
