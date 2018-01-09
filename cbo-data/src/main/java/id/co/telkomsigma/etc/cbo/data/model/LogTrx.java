package id.co.telkomsigma.etc.cbo.data.model;

import id.co.telkomsigma.tmf.data.model.base.ACrudDATA;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created on 1/5/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = "t_log_trx")
public class LogTrx extends ACrudDATA<Long> {

    private Double inputDataControlId;
    private String tbRowId;
    private String trxReq;
    private Date logDate;
    private String flagLog;
    private String trxResp;
    private Date updateRespon;
    private String errorReq;
    private String errorResp;

    @Column(name = "input_data_control_id")
    public Double getInputDataControlId() {
        return inputDataControlId;
    }

    public void setInputDataControlId(Double inputDataControlId) {
        this.inputDataControlId = inputDataControlId;
    }

    @Column(name = "tb_row_id")
    public String getTbRowId() {
        return tbRowId;
    }

    public void setTbRowId(String tbRowId) {
        this.tbRowId = tbRowId;
    }

    @Column(name = "trx_req")
    public String getTrxReq() {
        return trxReq;
    }

    public void setTrxReq(String trxReq) {
        this.trxReq = trxReq;
    }

    @Column(name = "log_date")
    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    @Column(name = "flag_log")
    public String getFlagLog() {
        return flagLog;
    }

    public void setFlagLog(String flagLog) {
        this.flagLog = flagLog;
    }

    @Column(name = "trx_resp")
    public String getTrxResp() {
        return trxResp;
    }

    public void setTrxResp(String trxResp) {
        this.trxResp = trxResp;
    }

    @Column(name = "update_respon")
    public Date getUpdateRespon() {
        return updateRespon;
    }

    public void setUpdateRespon(Date updateRespon) {
        this.updateRespon = updateRespon;
    }

    @Column(name = "error_req")
    public String getErrorReq() {
        return errorReq;
    }

    public void setErrorReq(String errorReq) {
        this.errorReq = errorReq;
    }

    @Column(name = "error_resp")
    public String getErrorResp() {
        return errorResp;
    }

    public void setErrorResp(String errorResp) {
        this.errorResp = errorResp;
    }
}
