package id.co.telkomsigma.etc.cbo.data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created on 9/28/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = "subscriber", schema = "bill")
public class Subscriber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscriber_id")
    private Long subscriberId;

    @Column(name = "service_no", unique = true)
    private String serviceNo;

    @Column(name = "subscription_name")
    private String subscriptionName;

    @Column(name = "customer_account_id")
    private Double customerAccountId;

    @Column(name = "p_service_type_id")
    private Integer pServiceTypeId;

    @Column(name = "qty_sub_from")
    private Integer qtySubFrom;

    @Column(name = "qty_sub_to")
    private Integer qtySubTo;

    @Column(name = "p_tariff_scenario_id")
    private Integer pTariffScenarioId;

    @Column(name = "p_bill_cycle_id")
    private Integer pBillCycleId;

    @Column(name = "p_subscription_status_id")
    private Integer pSubscriptionStatusId;

    @Column(name = "last_status_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastStatusDate;

    @Column(name = "is_invoiced")
    private Character isInvoice;

    @Column(name = "p_subscriber_segment_id")
    private Integer pSubscriberSegmentId;

    @Column(name = "is_vat_exception")
    private Character isVatException;

    @Column(name = "p_billing_period_unit_id")
    private Integer pBillingPeriodUnitId;

    @Column(name = "billing_unit")
    private Integer billingUnit;

    @Column(name = "subscription_type_id")
    private Integer subscriptionTypeId;

    @Column(name = "building_type_id")
    private Integer buildingTypeId;

    @Column(name = "building_status_id")
    private Integer buildingStatusId;

    @Column(name = "p_sales_person_id")
    private Integer pSalesPersonId;

    @Column(name = "address_1")
    private String address1;

    @Column(name = "address_2")
    private String address2;

    @Column(name = "address_3")
    private String address3;

    @Column(name = "p_region_id")
    private Integer pRegionId;

    @Column(name = "zip_code")
    private Integer zipCode;

    @Column(name = "active_date", unique = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date activeDate;

    @Column(name = "termination_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date terminationDate;

    @Column(name = "start_invoice_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startInvoiceDate;

    @Column(name = "end_invoice_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endInvoiceDate;

    @Column(name = "contract_number")
    private String contractNumber;

    @Column(name = "em_degree")
    private Integer emDegree;

    @Column(name = "em_minute")
    private Integer emMinute;

    @Column(name = "em_second")
    private Integer emSecond;

    @Column(name = "sl_degree")
    private Integer slDegree;

    @Column(name = "sl_minute")
    private Integer slMinute;

    @Column(name = "sl_second")
    private Integer slSecond;

    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(name = "update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedate;

    @Column(name = "update_by")
    private String updateBy;

    @Column(name = "p_business_area_id")
    private Integer pBusinessAreaId;

    @Column(name = "p_sub_business_area_id")
    private Integer pSubBusinessAreaId;

    @Column(name = "description")
    private String description;

    @Column(name = "p_service_group_id")
    private Integer pServiceGroupId;

    @Column(name = "re_activation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reActivationDate;

    @Column(name = "is_payment_key")
    private String isPaymentKey;

    @Column(name = "p_customer_segment_id")
    private Integer pCustomerSegmentId;

    @Column(name = "p_business_segment_id")
    private Integer pBusinessSegmentId;

    @Column(name = "p_debtor_segment_id")
    private Integer pDebtorSegmentId;

    @Column(name = "last_balance")
    private BigDecimal lastBalance;

    @Column(name = "last_balance_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastBalanceDate;

    @Column(name = "current_balance")
    private BigDecimal currentBalance;

    @Column(name = "e_money_id")
    private String eMoneyId;

    public Long getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(Long subscriberId) {
        this.subscriberId = subscriberId;
    }

    public String getServiceNo() {
        return serviceNo;
    }

    public void setServiceNo(String serviceNo) {
        this.serviceNo = serviceNo;
    }

    public String getSubscriptionName() {
        return subscriptionName;
    }

    public void setSubscriptionName(String subscriptionName) {
        this.subscriptionName = subscriptionName;
    }

    public Double getCustomerAccountId() {
        return customerAccountId;
    }

    public void setCustomerAccountId(Double customerAccountId) {
        this.customerAccountId = customerAccountId;
    }

    public Integer getpServiceTypeId() {
        return pServiceTypeId;
    }

    public void setpServiceTypeId(Integer pServiceTypeId) {
        this.pServiceTypeId = pServiceTypeId;
    }

    public Integer getQtySubFrom() {
        return qtySubFrom;
    }

    public void setQtySubFrom(Integer qtySubFrom) {
        this.qtySubFrom = qtySubFrom;
    }

    public Integer getQtySubTo() {
        return qtySubTo;
    }

    public void setQtySubTo(Integer qtySubTo) {
        this.qtySubTo = qtySubTo;
    }

    public Integer getpTariffScenarioId() {
        return pTariffScenarioId;
    }

    public void setpTariffScenarioId(Integer pTariffScenarioId) {
        this.pTariffScenarioId = pTariffScenarioId;
    }

    public Integer getpBillCycleId() {
        return pBillCycleId;
    }

    public void setpBillCycleId(Integer pBillCycleId) {
        this.pBillCycleId = pBillCycleId;
    }

    public Integer getpSubscriptionStatusId() {
        return pSubscriptionStatusId;
    }

    public void setpSubscriptionStatusId(Integer pSubscriptionStatusId) {
        this.pSubscriptionStatusId = pSubscriptionStatusId;
    }

    public Date getLastStatusDate() {
        return lastStatusDate;
    }

    public void setLastStatusDate(Date lastStatusDate) {
        this.lastStatusDate = lastStatusDate;
    }

    public Character getIsInvoice() {
        return isInvoice;
    }

    public void setIsInvoice(Character isInvoice) {
        this.isInvoice = isInvoice;
    }

    public Integer getpSubscriberSegmentId() {
        return pSubscriberSegmentId;
    }

    public void setpSubscriberSegmentId(Integer pSubscriberSegmentId) {
        this.pSubscriberSegmentId = pSubscriberSegmentId;
    }

    public Character getIsVatException() {
        return isVatException;
    }

    public void setIsVatException(Character isVatException) {
        this.isVatException = isVatException;
    }

    public Integer getpBillingPeriodUnitId() {
        return pBillingPeriodUnitId;
    }

    public void setpBillingPeriodUnitId(Integer pBillingPeriodUnitId) {
        this.pBillingPeriodUnitId = pBillingPeriodUnitId;
    }

    public Integer getBillingUnit() {
        return billingUnit;
    }

    public void setBillingUnit(Integer billingUnit) {
        this.billingUnit = billingUnit;
    }

    public Integer getSubscriptionTypeId() {
        return subscriptionTypeId;
    }

    public void setSubscriptionTypeId(Integer subscriptionTypeId) {
        this.subscriptionTypeId = subscriptionTypeId;
    }

    public Integer getBuildingTypeId() {
        return buildingTypeId;
    }

    public void setBuildingTypeId(Integer buildingTypeId) {
        this.buildingTypeId = buildingTypeId;
    }

    public Integer getBuildingStatusId() {
        return buildingStatusId;
    }

    public void setBuildingStatusId(Integer buildingStatusId) {
        this.buildingStatusId = buildingStatusId;
    }

    public Integer getpSalesPersonId() {
        return pSalesPersonId;
    }

    public void setpSalesPersonId(Integer pSalesPersonId) {
        this.pSalesPersonId = pSalesPersonId;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public Integer getpRegionId() {
        return pRegionId;
    }

    public void setpRegionId(Integer pRegionId) {
        this.pRegionId = pRegionId;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public Date getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(Date activeDate) {
        this.activeDate = activeDate;
    }

    public Date getTerminationDate() {
        return terminationDate;
    }

    public void setTerminationDate(Date terminationDate) {
        this.terminationDate = terminationDate;
    }

    public Date getStartInvoiceDate() {
        return startInvoiceDate;
    }

    public void setStartInvoiceDate(Date startInvoiceDate) {
        this.startInvoiceDate = startInvoiceDate;
    }

    public Date getEndInvoiceDate() {
        return endInvoiceDate;
    }

    public void setEndInvoiceDate(Date endInvoiceDate) {
        this.endInvoiceDate = endInvoiceDate;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public Integer getEmDegree() {
        return emDegree;
    }

    public void setEmDegree(Integer emDegree) {
        this.emDegree = emDegree;
    }

    public Integer getEmMinute() {
        return emMinute;
    }

    public void setEmMinute(Integer emMinute) {
        this.emMinute = emMinute;
    }

    public Integer getEmSecond() {
        return emSecond;
    }

    public void setEmSecond(Integer emSecond) {
        this.emSecond = emSecond;
    }

    public Integer getSlDegree() {
        return slDegree;
    }

    public void setSlDegree(Integer slDegree) {
        this.slDegree = slDegree;
    }

    public Integer getSlMinute() {
        return slMinute;
    }

    public void setSlMinute(Integer slMinute) {
        this.slMinute = slMinute;
    }

    public Integer getSlSecond() {
        return slSecond;
    }

    public void setSlSecond(Integer slSecond) {
        this.slSecond = slSecond;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Integer getpBusinessAreaId() {
        return pBusinessAreaId;
    }

    public void setpBusinessAreaId(Integer pBusinessAreaId) {
        this.pBusinessAreaId = pBusinessAreaId;
    }

    public Integer getpSubBusinessAreaId() {
        return pSubBusinessAreaId;
    }

    public void setpSubBusinessAreaId(Integer pSubBusinessAreaId) {
        this.pSubBusinessAreaId = pSubBusinessAreaId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getpServiceGroupId() {
        return pServiceGroupId;
    }

    public void setpServiceGroupId(Integer pServiceGroupId) {
        this.pServiceGroupId = pServiceGroupId;
    }

    public Date getReActivationDate() {
        return reActivationDate;
    }

    public void setReActivationDate(Date reActivationDate) {
        this.reActivationDate = reActivationDate;
    }

    public String getIsPaymentKey() {
        return isPaymentKey;
    }

    public void setIsPaymentKey(String isPaymentKey) {
        this.isPaymentKey = isPaymentKey;
    }

    public Integer getpCustomerSegmentId() {
        return pCustomerSegmentId;
    }

    public void setpCustomerSegmentId(Integer pCustomerSegmentId) {
        this.pCustomerSegmentId = pCustomerSegmentId;
    }

    public Integer getpBusinessSegmentId() {
        return pBusinessSegmentId;
    }

    public void setpBusinessSegmentId(Integer pBusinessSegmentId) {
        this.pBusinessSegmentId = pBusinessSegmentId;
    }

    public Integer getpDebtorSegmentId() {
        return pDebtorSegmentId;
    }

    public void setpDebtorSegmentId(Integer pDebtorSegmentId) {
        this.pDebtorSegmentId = pDebtorSegmentId;
    }

    public BigDecimal getLastBalance() {
        return lastBalance;
    }

    public void setLastBalance(BigDecimal lastBalance) {
        this.lastBalance = lastBalance;
    }

    public Date getLastBalanceDate() {
        return lastBalanceDate;
    }

    public void setLastBalanceDate(Date lastBalanceDate) {
        this.lastBalanceDate = lastBalanceDate;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String geteMoneyId() {
        return eMoneyId;
    }

    public void seteMoneyId(String eMoneyId) {
        this.eMoneyId = eMoneyId;
    }
}
