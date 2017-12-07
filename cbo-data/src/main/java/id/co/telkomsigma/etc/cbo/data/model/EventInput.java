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
@Table(name = "t_event_input", schema = "public")
public class EventInput extends AAuditTrail {
    /**
     *
     *
     */
    private static final long serialVersionUID = 5752893545435970087L;

    private Long inputDataControlId;
    private Long jobControlId;
    private String walletId;
    private String obuId;
    private String trxRefferenceCode;
    private BigDecimal trxAmount;
    private String drcr;
    private Date eventBeginTime;
    private Date eventEndTime;
    private String gateCode;
    private String plazaCode;
    private String operatorCode;
    private Date processingDate;
    private String stationType;
    private String lane;
    private String direction;
    private String dst;
    private String signalingCode;
    private String manufactureId;
    private String obuStatus;
    private String signalingLevel;
    private String logIndex;
    private String returnFlag;
    private String priceCurrency;
    private String vehicleClass;
    private String seqValidPayment;
    private String seqDetection;
    private String seqEnforce;
    private String seqLcTransaction;
    private String seqVideoPicture;
    private String signalCodeBitmap;
    private String laneMode;
    private String lightSignalCode;
    private String exitAvc;
    private String exitAvcAxles;
    private String exitAvcWheels;
    private String exitAvcSensors;
    private String pan;
    private String expiryDate;
    private String usageControl;
    private String efccmCountry;
    private String efccmIssuer;
    private String efccmTypeOfContract;
    private String efccmContextVersion;
    private String rdSessionTime;
    private String rdSessionCountry;
    private String rdSessionIssuer;
    private String rdSessionPlaza;
    private String rdSessionLane;
    private String rdSessionStationType;
    private String rndRse;
    private String keyRef;
    private String obuAuthenticator;
    private String pictureFileName;
    private String isHit;
    private Double hitCounter;
    private Date timeStampTr;
    private Date lastHitTimeStamp;
    private String shift;
    private Date shiftDate;
    private BigDecimal balance;
    private String uuidInput;
    private String isRespon;

    @Override
    public String tableName() {
        return "t_event_input";
    }

    @Column(name = "input_data_control_id")
    public Long getInputDataControlId() {
        return inputDataControlId;
    }

    public void setInputDataControlId(Long inputDataControlId) {
        this.inputDataControlId = inputDataControlId;
    }

    @Column(name = "job_control_id")
    public Long getJobControlId() {
        return jobControlId;
    }

    public void setJobControlId(Long jobControlId) {
        this.jobControlId = jobControlId;
    }

    @Column(name = "wallet_id")
    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    @Column(name = "obu_id")
    public String getObuId() {
        return obuId;
    }

    public void setObuId(String obuId) {
        this.obuId = obuId;
    }

    @Column(name = "trx_refference_code")
    public String getTrxRefferenceCode() {
        return trxRefferenceCode;
    }

    public void setTrxRefferenceCode(String trxRefferenceCode) {
        this.trxRefferenceCode = trxRefferenceCode;
    }

    @Column(name = "trx_amount")
    public BigDecimal getTrxAmount() {
        return trxAmount;
    }

    public void setTrxAmount(BigDecimal trxAmount) {
        this.trxAmount = trxAmount;
    }

    @Column(name = "dr_cr")
    public String getDrcr() {
        return drcr;
    }

    public void setDrcr(String drcr) {
        this.drcr = drcr;
    }

    @Column(name = "event_begin_time")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getEventBeginTime() {
        return eventBeginTime;
    }

    public void setEventBeginTime(Date eventBeginTime) {
        this.eventBeginTime = eventBeginTime;
    }

    @Column(name = "event_end_time")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getEventEndTime() {
        return eventEndTime;
    }

    public void setEventEndTime(Date eventEndTime) {
        this.eventEndTime = eventEndTime;
    }

    @Column(name = "gate_code")
    public String getGateCode() {
        return gateCode;
    }

    public void setGateCode(String gateCode) {
        this.gateCode = gateCode;
    }

    @Column(name = "plaza_code")
    public String getPlazaCode() {
        return plazaCode;
    }

    public void setPlazaCode(String plazaCode) {
        this.plazaCode = plazaCode;
    }

    @Column(name = "operator_code")
    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    @Column(name = "processing_date")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getProcessingDate() {
        return processingDate;
    }

    public void setProcessingDate(Date processingDate) {
        this.processingDate = processingDate;
    }

    @Column(name = "station_type")
    public String getStationType() {
        return stationType;
    }

    public void setStationType(String stationType) {
        this.stationType = stationType;
    }

    @Column(name = "lane")
    public String getLane() {
        return lane;
    }

    public void setLane(String lane) {
        this.lane = lane;
    }

    @Column(name = "direction")
    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Column(name = "dst")
    public String getDst() {
        return dst;
    }

    public void setDst(String dst) {
        this.dst = dst;
    }

    @Column(name = "signaling_code")
    public String getSignalingCode() {
        return signalingCode;
    }

    public void setSignalingCode(String signalingCode) {
        this.signalingCode = signalingCode;
    }

    @Column(name = "manufactureid")
    public String getManufactureId() {
        return manufactureId;
    }

    public void setManufactureId(String manufactureId) {
        this.manufactureId = manufactureId;
    }

    @Column(name = "obu_status")
    public String getObuStatus() {
        return obuStatus;
    }

    public void setObuStatus(String obuStatus) {
        this.obuStatus = obuStatus;
    }

    @Column(name = "signaling_level")
    public String getSignalingLevel() {
        return signalingLevel;
    }

    public void setSignalingLevel(String signalingLevel) {
        this.signalingLevel = signalingLevel;
    }

    @Column(name = "log_index")
    public String getLogIndex() {
        return logIndex;
    }

    public void setLogIndex(String logIndex) {
        this.logIndex = logIndex;
    }

    @Column(name = "return_flag")
    public String getReturnFlag() {
        return returnFlag;
    }

    public void setReturnFlag(String returnFlag) {
        this.returnFlag = returnFlag;
    }

    @Column(name = "pricecurrency")
    public String getPriceCurrency() {
        return priceCurrency;
    }

    public void setPriceCurrency(String priceCurrency) {
        this.priceCurrency = priceCurrency;
    }

    @Column(name = "vehicleclass")
    public String getVehicleClass() {
        return vehicleClass;
    }

    public void setVehicleClass(String vehicleClass) {
        this.vehicleClass = vehicleClass;
    }

    @Column(name = "seqvalidpayment")
    public String getSeqValidPayment() {
        return seqValidPayment;
    }

    public void setSeqValidPayment(String seqValidPayment) {
        this.seqValidPayment = seqValidPayment;
    }

    @Column(name = "seqdetection")
    public String getSeqDetection() {
        return seqDetection;
    }

    public void setSeqDetection(String seqDetection) {
        this.seqDetection = seqDetection;
    }

    @Column(name = "seqenforced")
    public String getSeqEnforce() {
        return seqEnforce;
    }

    public void setSeqEnforce(String seqEnforce) {
        this.seqEnforce = seqEnforce;
    }

    @Column(name = "seqlctransaction")
    public String getSeqLcTransaction() {
        return seqLcTransaction;
    }

    public void setSeqLcTransaction(String seqLcTransaction) {
        this.seqLcTransaction = seqLcTransaction;
    }

    @Column(name = "seqvideopicture")
    public String getSeqVideoPicture() {
        return seqVideoPicture;
    }

    public void setSeqVideoPicture(String seqVideoPicture) {
        this.seqVideoPicture = seqVideoPicture;
    }

    @Column(name = "signalcodebitmap")
    public String getSignalCodeBitmap() {
        return signalCodeBitmap;
    }

    public void setSignalCodeBitmap(String signalCodeBitmap) {
        this.signalCodeBitmap = signalCodeBitmap;
    }

    @Column(name = "lanemode")
    public String getLaneMode() {
        return laneMode;
    }

    public void setLaneMode(String laneMode) {
        this.laneMode = laneMode;
    }

    @Column(name = "lightsignalcode")
    public String getLightSignalCode() {
        return lightSignalCode;
    }

    public void setLightSignalCode(String lightSignalCode) {
        this.lightSignalCode = lightSignalCode;
    }

    @Column(name = "exitavc")
    public String getExitAvc() {
        return exitAvc;
    }

    public void setExitAvc(String exitAvc) {
        this.exitAvc = exitAvc;
    }

    @Column(name = "exitavcaxles")
    public String getExitAvcAxles() {
        return exitAvcAxles;
    }

    public void setExitAvcAxles(String exitAvcAxles) {
        this.exitAvcAxles = exitAvcAxles;
    }

    @Column(name = "exitavcwheels")
    public String getExitAvcWheels() {
        return exitAvcWheels;
    }

    public void setExitAvcWheels(String exitAvcWheels) {
        this.exitAvcWheels = exitAvcWheels;
    }

    @Column(name = "exitavcsensors")
    public String getExitAvcSensors() {
        return exitAvcSensors;
    }

    public void setExitAvcSensors(String exitAvcSensors) {
        this.exitAvcSensors = exitAvcSensors;
    }

    @Column(name = "pan")
    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    @Column(name = "expirydate")
    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Column(name = "usagecontrol")
    public String getUsageControl() {
        return usageControl;
    }

    public void setUsageControl(String usageControl) {
        this.usageControl = usageControl;
    }

    @Column(name = "efccm_country")
    public String getEfccmCountry() {
        return efccmCountry;
    }

    public void setEfccmCountry(String efccmCountry) {
        this.efccmCountry = efccmCountry;
    }

    @Column(name = "efccm_issuer")
    public String getEfccmIssuer() {
        return efccmIssuer;
    }

    public void setEfccmIssuer(String efccmIssuer) {
        this.efccmIssuer = efccmIssuer;
    }

    @Column(name = "efccm_typeofcontr_act")
    public String getEfccmTypeOfContract() {
        return efccmTypeOfContract;
    }

    public void setEfccmTypeOfContract(String efccmTypeOfContract) {
        this.efccmTypeOfContract = efccmTypeOfContract;
    }

    @Column(name = "efccm_contextversi_on")
    public String getEfccmContextVersion() {
        return efccmContextVersion;
    }

    public void setEfccmContextVersion(String efccmContextVersion) {
        this.efccmContextVersion = efccmContextVersion;
    }

    @Column(name = "rd_sessiontime")
    public String getRdSessionTime() {
        return rdSessionTime;
    }

    public void setRdSessionTime(String rdSessionTime) {
        this.rdSessionTime = rdSessionTime;
    }

    @Column(name = "rd_sessioncountry")
    public String getRdSessionCountry() {
        return rdSessionCountry;
    }

    public void setRdSessionCountry(String rdSessionCountry) {
        this.rdSessionCountry = rdSessionCountry;
    }

    @Column(name = "rd_sessionissuer")
    public String getRdSessionIssuer() {
        return rdSessionIssuer;
    }

    public void setRdSessionIssuer(String rdSessionIssuer) {
        this.rdSessionIssuer = rdSessionIssuer;
    }

    @Column(name = "rd_sessionplaza")
    public String getRdSessionPlaza() {
        return rdSessionPlaza;
    }

    public void setRdSessionPlaza(String rdSessionPlaza) {
        this.rdSessionPlaza = rdSessionPlaza;
    }

    @Column(name = "rd_sessionlane")
    public String getRdSessionLane() {
        return rdSessionLane;
    }

    public void setRdSessionLane(String rdSessionLane) {
        this.rdSessionLane = rdSessionLane;
    }

    @Column(name = "rd_sessionstationty_pe")
    public String getRdSessionStationType() {
        return rdSessionStationType;
    }

    public void setRdSessionStationType(String rdSessionStationType) {
        this.rdSessionStationType = rdSessionStationType;
    }

    @Column(name = "rndrse")
    public String getRndRse() {
        return rndRse;
    }

    public void setRndRse(String rndRse) {
        this.rndRse = rndRse;
    }

    @Column(name = "keyref")
    public String getKeyRef() {
        return keyRef;
    }

    public void setKeyRef(String keyRef) {
        this.keyRef = keyRef;
    }

    @Column(name = "obuauthenticator")
    public String getObuAuthenticator() {
        return obuAuthenticator;
    }

    public void setObuAuthenticator(String obuAuthenticator) {
        this.obuAuthenticator = obuAuthenticator;
    }

    @Column(name = "picturefilename")
    public String getPictureFileName() {
        return pictureFileName;
    }

    public void setPictureFileName(String pictureFileName) {
        this.pictureFileName = pictureFileName;
    }

    @Column(name = "is_hit")
    public String getIsHit() {
        return isHit;
    }

    public void setIsHit(String isHit) {
        this.isHit = isHit;
    }

    @Column(name = "hit_counter")
    public Double getHitCounter() {
        return hitCounter;
    }

    public void setHitCounter(Double hitCounter) {
        this.hitCounter = hitCounter;
    }

    @Column(name = "timestamp_tr")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getTimeStampTr() {
        return timeStampTr;
    }

    public void setTimeStampTr(Date timeStampTr) {
        this.timeStampTr = timeStampTr;
    }

    @Column(name = "lasthittimestamp")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getLastHitTimeStamp() {
        return lastHitTimeStamp;
    }

    public void setLastHitTimeStamp(Date lastHitTimeStamp) {
        this.lastHitTimeStamp = lastHitTimeStamp;
    }

    @Column(name = "shift")
    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    @Column(name = "shift_date")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getShiftDate() {
        return shiftDate;
    }

    public void setShiftDate(Date shiftDate) {
        this.shiftDate = shiftDate;
    }

    @Column(name = "balance")
    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Column(name = "uuid_input")
    public String getUuidInput() {
        return uuidInput;
    }

    public void setUuidInput(String uuidInput) {
        this.uuidInput = uuidInput;
    }

    @Column(name = "is_respon")
    public String getIsRespon() {
        return isRespon;
    }

    public void setIsRespon(String isRespon) {
        this.isRespon = isRespon;
    }
}
