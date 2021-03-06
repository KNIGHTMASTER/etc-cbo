package id.co.telkomsigma.etc.cbo.data.model;

import id.co.telkomsigma.tmf.data.model.base.AAuditTrail;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created on 9/28/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = "subscriber", schema = "public")
public class Subscriber extends AAuditTrail {
    /**
     *
     *
     */
    private static final long serialVersionUID = -7599323531722689074L;

    private String serviceNo;
    private String subscriptionName;
    private Double customerAccountId;
    private Integer pServiceTypeId;
    private Integer qtySubFrom;
    private Integer qtySubTo;
    private Integer pTariffScenarioId;
    private Integer pBillCycleId;
    private Integer pSubscriptionStatusId;
    private Date lastStatusDate;
    private Character isInvoice;
    private Integer pSubscriberSegmentId;
    private Character isVatException;
    private Integer pBillingPeriodUnitId;
    private Integer billingUnit;
    private Integer subscriptionTypeId;
    private Integer buildingTypeId;
    private Integer buildingStatusId;
    private Integer pSalesPersonId;
    private String address1;
    private String address2;
    private String address3;
    private Integer pRegionId;
    private Integer zipCode;
    private Date activeDate;
    private Date terminationDate;
    private Date startInvoiceDate;
    private Date endInvoiceDate;
    private String contractNumber;
    private Integer emDegree;
    private Integer emMinute;
    private Integer emSecond;
    private Integer slDegree;
    private Integer slMinute;
    private Integer slSecond;
    private Date creationDate;
    private Date updatedate;
    private String updateBy;
    private Integer pBusinessAreaId;
    private Integer pSubBusinessAreaId;
    private String description;
    private Integer pServiceGroupId;
    private Date reActivationDate;
    private String isPaymentKey;
    private Integer pCustomerSegmentId;
    private Integer pBusinessSegmentId;
    private Integer pDebtorSegmentId;
    private BigDecimal lastBalance;
    private Date lastBalanceDate;
    private BigDecimal currentBalance;
    private String eMoneyId;

    @Column(name = "service_no", unique = true)
    public String getServiceNo() {
        return serviceNo;
    }

    public void setServiceNo(String serviceNo) {
        this.serviceNo = serviceNo;
    }

    @Column(name = "subscription_name")
    public String getSubscriptionName() {
        return subscriptionName;
    }

    public void setSubscriptionName(String subscriptionName) {
        this.subscriptionName = subscriptionName;
    }

    @Column(name = "customer_account_id")
    public Double getCustomerAccountId() {
        return customerAccountId;
    }

    public void setCustomerAccountId(Double customerAccountId) {
        this.customerAccountId = customerAccountId;
    }

    @Column(name = "p_service_type_id")
    public Integer getpServiceTypeId() {
        return pServiceTypeId;
    }

    public void setpServiceTypeId(Integer pServiceTypeId) {
        this.pServiceTypeId = pServiceTypeId;
    }

    @Column(name = "qty_sub_from")
    public Integer getQtySubFrom() {
        return qtySubFrom;
    }

    public void setQtySubFrom(Integer qtySubFrom) {
        this.qtySubFrom = qtySubFrom;
    }

    @Column(name = "qty_sub_to")
    public Integer getQtySubTo() {
        return qtySubTo;
    }

    public void setQtySubTo(Integer qtySubTo) {
        this.qtySubTo = qtySubTo;
    }

    @Column(name = "p_tariff_scenario_id")
    public Integer getpTariffScenarioId() {
        return pTariffScenarioId;
    }

    public void setpTariffScenarioId(Integer pTariffScenarioId) {
        this.pTariffScenarioId = pTariffScenarioId;
    }

    @Column(name = "p_bill_cycle_id")
    public Integer getpBillCycleId() {
        return pBillCycleId;
    }

    public void setpBillCycleId(Integer pBillCycleId) {
        this.pBillCycleId = pBillCycleId;
    }

    @Column(name = "p_subscription_status_id")
    public Integer getpSubscriptionStatusId() {
        return pSubscriptionStatusId;
    }

    public void setpSubscriptionStatusId(Integer pSubscriptionStatusId) {
        this.pSubscriptionStatusId = pSubscriptionStatusId;
    }

    @Column(name = "last_status_date")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getLastStatusDate() {
        return lastStatusDate;
    }

    public void setLastStatusDate(Date lastStatusDate) {
        this.lastStatusDate = lastStatusDate;
    }

    @Column(name = "is_invoiced")
    public Character getIsInvoice() {
        return isInvoice;
    }

    public void setIsInvoice(Character isInvoice) {
        this.isInvoice = isInvoice;
    }

    @Column(name = "p_subscriber_segment_id")
    public Integer getpSubscriberSegmentId() {
        return pSubscriberSegmentId;
    }

    public void setpSubscriberSegmentId(Integer pSubscriberSegmentId) {
        this.pSubscriberSegmentId = pSubscriberSegmentId;
    }

    @Column(name = "is_vat_exception")
    public Character getIsVatException() {
        return isVatException;
    }

    public void setIsVatException(Character isVatException) {
        this.isVatException = isVatException;
    }

    @Column(name = "p_billing_period_unit_id")
    public Integer getpBillingPeriodUnitId() {
        return pBillingPeriodUnitId;
    }

    public void setpBillingPeriodUnitId(Integer pBillingPeriodUnitId) {
        this.pBillingPeriodUnitId = pBillingPeriodUnitId;
    }

    @Column(name = "billing_unit")
    public Integer getBillingUnit() {
        return billingUnit;
    }

    public void setBillingUnit(Integer billingUnit) {
        this.billingUnit = billingUnit;
    }

    @Column(name = "subscription_type_id")
    public Integer getSubscriptionTypeId() {
        return subscriptionTypeId;
    }

    public void setSubscriptionTypeId(Integer subscriptionTypeId) {
        this.subscriptionTypeId = subscriptionTypeId;
    }

    @Column(name = "building_type_id")
    public Integer getBuildingTypeId() {
        return buildingTypeId;
    }

    public void setBuildingTypeId(Integer buildingTypeId) {
        this.buildingTypeId = buildingTypeId;
    }

    @Column(name = "building_status_id")
    public Integer getBuildingStatusId() {
        return buildingStatusId;
    }

    public void setBuildingStatusId(Integer buildingStatusId) {
        this.buildingStatusId = buildingStatusId;
    }

    @Column(name = "p_sales_person_id")
    public Integer getpSalesPersonId() {
        return pSalesPersonId;
    }

    public void setpSalesPersonId(Integer pSalesPersonId) {
        this.pSalesPersonId = pSalesPersonId;
    }

    @Column(name = "address_1")
    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    @Column(name = "address_2")
    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    @Column(name = "address_3")
    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    @Column(name = "p_region_id")
    public Integer getpRegionId() {
        return pRegionId;
    }

    public void setpRegionId(Integer pRegionId) {
        this.pRegionId = pRegionId;
    }

    @Column(name = "zip_code")
    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    @Column(name = "active_date", unique = true)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(Date activeDate) {
        this.activeDate = activeDate;
    }

    @Column(name = "termination_date")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getTerminationDate() {
        return terminationDate;
    }

    public void setTerminationDate(Date terminationDate) {
        this.terminationDate = terminationDate;
    }

    @Column(name = "start_invoice_date")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getStartInvoiceDate() {
        return startInvoiceDate;
    }

    public void setStartInvoiceDate(Date startInvoiceDate) {
        this.startInvoiceDate = startInvoiceDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_invoice_date")
    public Date getEndInvoiceDate() {
        return endInvoiceDate;
    }

    public void setEndInvoiceDate(Date endInvoiceDate) {
        this.endInvoiceDate = endInvoiceDate;
    }

    @Column(name = "contract_number")
    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
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
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Column(name = "update_date")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    @Column(name = "update_by")
    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    @Column(name = "p_business_area_id")
    public Integer getpBusinessAreaId() {
        return pBusinessAreaId;
    }

    public void setpBusinessAreaId(Integer pBusinessAreaId) {
        this.pBusinessAreaId = pBusinessAreaId;
    }

    @Column(name = "p_sub_business_area_id")
    public Integer getpSubBusinessAreaId() {
        return pSubBusinessAreaId;
    }

    public void setpSubBusinessAreaId(Integer pSubBusinessAreaId) {
        this.pSubBusinessAreaId = pSubBusinessAreaId;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "p_service_group_id")
    public Integer getpServiceGroupId() {
        return pServiceGroupId;
    }

    public void setpServiceGroupId(Integer pServiceGroupId) {
        this.pServiceGroupId = pServiceGroupId;
    }

    @Column(name = "re_activation_date")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getReActivationDate() {
        return reActivationDate;
    }

    public void setReActivationDate(Date reActivationDate) {
        this.reActivationDate = reActivationDate;
    }

    @Column(name = "is_payment_key")
    public String getIsPaymentKey() {
        return isPaymentKey;
    }

    public void setIsPaymentKey(String isPaymentKey) {
        this.isPaymentKey = isPaymentKey;
    }

    @Column(name = "p_customer_segment_id")
    public Integer getpCustomerSegmentId() {
        return pCustomerSegmentId;
    }

    public void setpCustomerSegmentId(Integer pCustomerSegmentId) {
        this.pCustomerSegmentId = pCustomerSegmentId;
    }

    @Column(name = "p_business_segment_id")
    public Integer getpBusinessSegmentId() {
        return pBusinessSegmentId;
    }

    public void setpBusinessSegmentId(Integer pBusinessSegmentId) {
        this.pBusinessSegmentId = pBusinessSegmentId;
    }

    @Column(name = "p_debtor_segment_id")
    public Integer getpDebtorSegmentId() {
        return pDebtorSegmentId;
    }

    public void setpDebtorSegmentId(Integer pDebtorSegmentId) {
        this.pDebtorSegmentId = pDebtorSegmentId;
    }

    @Column(name = "last_balance")
    public BigDecimal getLastBalance() {
        return lastBalance;
    }

    public void setLastBalance(BigDecimal lastBalance) {
        this.lastBalance = lastBalance;
    }

    @Column(name = "last_balance_date")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getLastBalanceDate() {
        return lastBalanceDate;
    }

    public void setLastBalanceDate(Date lastBalanceDate) {
        this.lastBalanceDate = lastBalanceDate;
    }

    @Column(name = "current_balance")
    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    @Column(name = "e_money_id")
    public String geteMoneyId() {
        return eMoneyId;
    }

    public void seteMoneyId(String eMoneyId) {
        this.eMoneyId = eMoneyId;
    }

    @Override
    public String tableName() {
        return "subscriber";
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "currentBalance=" + currentBalance +
                '}';
    }
}
