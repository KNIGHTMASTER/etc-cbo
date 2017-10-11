package id.co.telkomsigma.etc.cbo.data.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created on 10/11/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = "p_plaza", schema = "public")
public class Plaza {
    /**
     *
     *
     */
    private static final long serialVersionUID = 8182337006374732827L;

    private Integer plazaId;
    private String plazaCode;
    private String plazaName;
    private String description;
    private Integer emDegree;
    private Integer emMinute;
    private Integer emSecond;
    private Integer slDegree;
    private Integer slMinute;
    private Integer slSecond;
    private Date creationDate;
    private String createdBy;
    private Date updateDate;
    private String updateBy;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_plaza_id")
    public Integer getPlazaId() {
        return plazaId;
    }

    public void setPlazaId(Integer plazaId) {
        this.plazaId = plazaId;
    }

    @Column(name = "plaza_code")
    public String getPlazaCode() {
        return plazaCode;
    }

    public void setPlazaCode(String plazaCode) {
        this.plazaCode = plazaCode;
    }

    @Column(name = "plaza_name")
    public String getPlazaName() {
        return plazaName;
    }

    public void setPlazaName(String plazaName) {
        this.plazaName = plazaName;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "em_degree")
    public Integer getEmDegree() {
        return emDegree;
    }

    public void setEmDegree(Integer emDegree) {
        this.emDegree = emDegree;
    }

    @Column(name = "em_minute")
    public Integer getEmMinute() {
        return emMinute;
    }

    public void setEmMinute(Integer emMinute) {
        this.emMinute = emMinute;
    }

    @Column(name = "em_second")
    public Integer getEmSecond() {
        return emSecond;
    }

    public void setEmSecond(Integer emSecond) {
        this.emSecond = emSecond;
    }

    @Column(name = "sl_degree")
    public Integer getSlDegree() {
        return slDegree;
    }

    public void setSlDegree(Integer slDegree) {
        this.slDegree = slDegree;
    }

    @Column(name = "sl_minute")
    public Integer getSlMinute() {
        return slMinute;
    }

    public void setSlMinute(Integer slMinute) {
        this.slMinute = slMinute;
    }

    @Column(name = "sl_second")
    public Integer getSlSecond() {
        return slSecond;
    }

    public void setSlSecond(Integer slSecond) {
        this.slSecond = slSecond;
    }

    @Column(name = "creation_date")
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Column(name = "created_by")
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name = "updated_date")
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Column(name = "updated_by")
    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

}
