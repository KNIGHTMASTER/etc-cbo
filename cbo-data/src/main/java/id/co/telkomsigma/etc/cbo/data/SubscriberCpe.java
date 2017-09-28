package id.co.telkomsigma.etc.cbo.data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created on 9/28/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = "subscriber_cpe", schema = "bill")
public class SubscriberCpe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscriber_cpe_id")
    private Long subscriberCpeId;

    @Column(name = "subscriber_id")
    private Long subscriberId;

    @Column(name = "cpe_list_id")
    private Long cpeListId;

    @Column(name = "valid_from")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validFrom;

    @Column(name = "valid_to")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validTo;

    @Column(name = "description")
    private String description;

    @Column(name = "update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    @Column(name = "update_by")
    private String updateBy;

    public Long getSubscriberCpeId() {
        return subscriberCpeId;
    }

    public void setSubscriberCpeId(Long subscriberCpeId) {
        this.subscriberCpeId = subscriberCpeId;
    }

    public Long getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(Long subscriberId) {
        this.subscriberId = subscriberId;
    }

    public Long getCpeListId() {
        return cpeListId;
    }

    public void setCpeListId(Long cpeListId) {
        this.cpeListId = cpeListId;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
}
