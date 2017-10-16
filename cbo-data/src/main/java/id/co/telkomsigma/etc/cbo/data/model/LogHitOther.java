package id.co.telkomsigma.etc.cbo.data.model;

import id.co.telkomsigma.tmf.data.model.base.ACrudDATA;

import javax.persistence.*;
import java.util.Date;

/**
 * Created on 10/13/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = "t_log_hitother", schema = "public")
public class LogHitOther extends ACrudDATA<Long> {

    private Date logDate;
    private String flagLog;
    private String errorResponse;
    private Date dateRequest;

    @Column(name = "log_date")
    @Temporal(TemporalType.TIMESTAMP)
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

    @Column(name = "error_resp")
    public String getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(String errorResponse) {
        this.errorResponse = errorResponse;
    }

    @Column(name = "date_req")
    public Date getDateRequest() {
        return dateRequest;
    }

    public void setDateRequest(Date dateRequest) {
        this.dateRequest = dateRequest;
    }
}
