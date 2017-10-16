package id.co.telkomsigma.etc.cbo.data.model;

import id.co.telkomsigma.tmf.data.model.base.ACrudDATA;

import javax.persistence.*;
import java.util.Date;

/**
 * Created on 10/16/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = "process_log2", schema = "public")
public class ProcessLog2 extends ACrudDATA<Long> {

    private Integer controlTableId;
    private Integer controlDataId;
    private Date logDate;
    private String logMessage;
    private String val1;
    private String val2;
    private String val3;
    private String val4;


    @Column(name = "control_table_id")
    public Integer getControlTableId() {
        return controlTableId;
    }

    public void setControlTableId(Integer controlTableId) {
        this.controlTableId = controlTableId;
    }

    @Column(name = "control_data_id")
    public Integer getControlDataId() {
        return controlDataId;
    }

    public void setControlDataId(Integer controlDataId) {
        this.controlDataId = controlDataId;
    }

    @Column(name = "log_date")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    @Column(name = "log_msg")
    public String getLogMessage() {
        return logMessage;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }

    @Column(name = "val_1")
    public String getVal1() {
        return val1;
    }

    public void setVal1(String val1) {
        this.val1 = val1;
    }

    @Column(name = "val_2")
    public String getVal2() {
        return val2;
    }

    public void setVal2(String val2) {
        this.val2 = val2;
    }

    @Column(name = "val_3")
    public String getVal3() {
        return val3;
    }

    public void setVal3(String val3) {
        this.val3 = val3;
    }

    @Column(name = "val_4")
    public String getVal4() {
        return val4;
    }

    public void setVal4(String val4) {
        this.val4 = val4;
    }
}
