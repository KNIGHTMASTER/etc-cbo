package id.co.telkomsigma.etc.cbo.data.model;

import id.co.telkomsigma.tmf.data.model.base.AAuditTrail;

import javax.persistence.*;
import java.util.Date;

/**
 * Created on 9/28/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = "cpe_list", schema = "public")
public class CpeList extends AAuditTrail {
    /**
     *
     *
     */
    private static final long serialVersionUID = 2530337063626708966L;

    @Column(name = "serial_no", unique = true)
    private String serialNo;

    @Column(name = "pan")
    private String pan;

    @Column(name = "p_cpe_type_id", unique = true)
    private Integer pCpeTypeId;

    @Column(name = "p_cpe_brand_id", unique = true)
    private Integer pCpeBrandId;

    @Column(name = "p_cpe_status_id")
    private Integer pCpeStatusId;

    @Column(name = "p_cpe_location_type_id")
    private Integer pCpeLocationTypeId;

    @Column(name = "cpe_location_id")
    private Integer cpeLocationId;

    @Column(name = "subs_location_id")
    private Double subsLocationId;

    @Column(name = "description")
    private String description;

    @Column(name = "update_by")
    private String updateBy;

    @Column(name = "update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public Integer getpCpeTypeId() {
        return pCpeTypeId;
    }

    public void setpCpeTypeId(Integer pCpeTypeId) {
        this.pCpeTypeId = pCpeTypeId;
    }

    public Integer getpCpeBrandId() {
        return pCpeBrandId;
    }

    public void setpCpeBrandId(Integer pCpeBrandId) {
        this.pCpeBrandId = pCpeBrandId;
    }

    public Integer getpCpeStatusId() {
        return pCpeStatusId;
    }

    public void setpCpeStatusId(Integer pCpeStatusId) {
        this.pCpeStatusId = pCpeStatusId;
    }

    public Integer getpCpeLocationTypeId() {
        return pCpeLocationTypeId;
    }

    public void setpCpeLocationTypeId(Integer pCpeLocationTypeId) {
        this.pCpeLocationTypeId = pCpeLocationTypeId;
    }

    public Integer getCpeLocationId() {
        return cpeLocationId;
    }

    public void setCpeLocationId(Integer cpeLocationId) {
        this.cpeLocationId = cpeLocationId;
    }

    public Double getSubsLocationId() {
        return subsLocationId;
    }

    public void setSubsLocationId(Double subsLocationId) {
        this.subsLocationId = subsLocationId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String tableName() {
        return "cpe_list";
    }
}
