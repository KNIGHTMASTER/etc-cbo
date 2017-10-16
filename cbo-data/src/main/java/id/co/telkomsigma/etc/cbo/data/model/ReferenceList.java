package id.co.telkomsigma.etc.cbo.data.model;

import id.co.telkomsigma.tmf.data.model.base.ACrudDATA;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created on 10/16/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = "p_reference_list", schema = "public")
public class ReferenceList extends ACrudDATA<Long> {

    private String code;
    private Integer referenceTypeId;
    private String referenceName;
    private Integer listingNo;
    private String description;
    private Date updateDate;
    private String updateBy;

    @Column(name = "code", unique = true)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "p_reference_type_id", unique = true)
    public Integer getReferenceTypeId() {
        return referenceTypeId;
    }

    public void setReferenceTypeId(Integer referenceTypeId) {
        this.referenceTypeId = referenceTypeId;
    }

    @Column(name = "reference_name")
    public String getReferenceName() {
        return referenceName;
    }

    public void setReferenceName(String referenceName) {
        this.referenceName = referenceName;
    }

    @Column(name = "listing_no")
    public Integer getListingNo() {
        return listingNo;
    }

    public void setListingNo(Integer listingNo) {
        this.listingNo = listingNo;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "update_date")
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Column(name = "update_by")
    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
}
