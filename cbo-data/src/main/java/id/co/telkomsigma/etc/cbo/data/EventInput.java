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
@Table(name = "t_event_input", schema = "bill")
public class EventInput {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "input_data_control_id")
    private Long inputDataControlId;

    @Column(name = "job_control_id")
    private Long jobControlId;

    @Column(name = "event_type_id")
    private Integer eventTypeId;

    @Column(name = "wallet_id")
    private String walletId;

    @Column(name = "obu_id")
    private String obuId;

    @Column(name = "trx_refference_code")
    private String trxRefferenceCode;

    @Column(name = "trx_amount")
    private BigDecimal trxAmount;

    @Column(name = "dr_cr")
    private String drcr;

    @Column(name = "event_begin_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eventBeginTime;

    @Column(name = "event_end_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eventEndTime;

    @Column(name = "gate_code")
    private String gateCode;

    @Column(name = "plaza_code")
    private String plazaCode;

    @Column(name = "operator_code")
    private String operatorCode;

    @Column(name = "processing_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date processingDate;

    @Column(name = "station_type")
    private String stationType;

    @Column(name = "lane")
    private String lane;

    @Column(name = "direction")
    private String direction;

    @Column(name = "dst")
    private String dst;

    @Column(name = "signaling_code")
    private String signalingCode;

    @Column(name = "manufactureid")
    private String manufactureId;

    @Column(name = "obu_status")
    private String obuStatus;

    @Column(name = "signaling_level")
    private String signalingLevel;

    @Column(name = "log_index")
    private String logIndex;

    @Column(name = "return_flag")
    private String returnFlag;

    @Column(name = "pricecurrency")
    private String priceCurrency;

    @Column(name = "vehicleclass")
    private String vehicleClass;

    @Column(name = "seqvalidpayment")
    private String seqValidPayment;

    @Column(name = "seqdetection")
    private String seqDetection;

    @Column(name = "seqenforced")
    private String seqEnforce;

    @Column(name = "seqlctransaction")
    private String seqLcTransaction;

    @Column(name = "seqvideopicture")
    private String seqVideoPicture;

    @Column(name = "signalcodebitmap")
    private String signalCodeBitmap;

    @Column(name = "lanemode")
    private String laneMode;

    @Column(name = "lightsignalcode")
    private String lightSignalCode;

    @Column(name = "exitavc")
    private String exitAvc;

    @Column(name = "exitavcaxles")
    private String exitAvcAxles;

    @Column(name = "exitavcwheels")
    private String exitAvcWheels;

    @Column(name = "exitavcsensors")
    private String exitAvcSensors;

    @Column(name = "pan")
    private String pan;

    @Column(name = "expirydate")
    private String expiryDate;

    @Column(name = "usagecontrol")
    private String usageControl;

    @Column(name = "efccm_country")
    private String efccmCountry;

    @Column(name = "efccm_issuer")
    private String efccmIssuer;

    @Column(name = "efccm_typeofcontr_act")
    private String efccmTypeOfContract;

    @Column(name = "efccm_contextversi_on")
    private String efccmContextVersion;

    @Column(name = "rd_sessiontime")
    private String rdSessionTime;

    @Column(name = "rd_sessioncountry")
    private String rdSessionCountry;

    @Column(name = "rd_sessionissuer")
    private String rdSessionIssuer;

    @Column(name = "rd_sessionplaza")
    private String rdSessionPlaza;

    @Column(name = "rd_sessionlane")
    private String rdSessionLane;

    @Column(name = "rd_sessionstationty_pe")
    private String rdSessionStationType;

    @Column(name = "rndrse")
    private String rndRse;

    @Column(name = "keyref")
    private String keyRef;

    @Column(name = "obuauthenticator")
    private String obuAuthenticator;

    @Column(name = "picturefilename")
    private String pictureFileName;

    @Column(name = "is_hit")
    private String isHit;

    @Column(name = "hit_counter")
    private Double hitCounter;

    @Column(name = "timestamp_tr")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStampTr;

    @Column(name = "lasthittimestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastHitTimeStamp;

    @Column(name = "shift")
    private String shift;

    @Column(name = "shift_date")
    @Temporal(TemporalType.TIMESTAMP)
    private String shitDate;

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "uuid_input")
    private String uuidInput;

    @Column(name = "is_respon")
    private String isRespon;

    public Long getInputDataControlId() {
        return inputDataControlId;
    }

    public void setInputDataControlId(Long inputDataControlId) {
        this.inputDataControlId = inputDataControlId;
    }

    public Long getJobControlId() {
        return jobControlId;
    }

    public void setJobControlId(Long jobControlId) {
        this.jobControlId = jobControlId;
    }

    public Integer getEventTypeId() {
        return eventTypeId;
    }

    public void setEventTypeId(Integer eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public String getObuId() {
        return obuId;
    }

    public void setObuId(String obuId) {
        this.obuId = obuId;
    }

    public String getTrxRefferenceCode() {
        return trxRefferenceCode;
    }

    public void setTrxRefferenceCode(String trxRefferenceCode) {
        this.trxRefferenceCode = trxRefferenceCode;
    }

    public BigDecimal getTrxAmount() {
        return trxAmount;
    }

    public void setTrxAmount(BigDecimal trxAmount) {
        this.trxAmount = trxAmount;
    }

    public String getDrcr() {
        return drcr;
    }

    public void setDrcr(String drcr) {
        this.drcr = drcr;
    }

    public Date getEventBeginTime() {
        return eventBeginTime;
    }

    public void setEventBeginTime(Date eventBeginTime) {
        this.eventBeginTime = eventBeginTime;
    }

    public Date getEventEndTime() {
        return eventEndTime;
    }

    public void setEventEndTime(Date eventEndTime) {
        this.eventEndTime = eventEndTime;
    }

    public String getGateCode() {
        return gateCode;
    }

    public void setGateCode(String gateCode) {
        this.gateCode = gateCode;
    }

    public String getPlazaCode() {
        return plazaCode;
    }

    public void setPlazaCode(String plazaCode) {
        this.plazaCode = plazaCode;
    }

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    public Date getProcessingDate() {
        return processingDate;
    }

    public void setProcessingDate(Date processingDate) {
        this.processingDate = processingDate;
    }

    public String getStationType() {
        return stationType;
    }

    public void setStationType(String stationType) {
        this.stationType = stationType;
    }

    public String getLane() {
        return lane;
    }

    public void setLane(String lane) {
        this.lane = lane;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDst() {
        return dst;
    }

    public void setDst(String dst) {
        this.dst = dst;
    }

    public String getSignalingCode() {
        return signalingCode;
    }

    public void setSignalingCode(String signalingCode) {
        this.signalingCode = signalingCode;
    }

    public String getManufactureId() {
        return manufactureId;
    }

    public void setManufactureId(String manufactureId) {
        this.manufactureId = manufactureId;
    }

    public String getObuStatus() {
        return obuStatus;
    }

    public void setObuStatus(String obuStatus) {
        this.obuStatus = obuStatus;
    }

    public String getSignalingLevel() {
        return signalingLevel;
    }

    public void setSignalingLevel(String signalingLevel) {
        this.signalingLevel = signalingLevel;
    }

    public String getLogIndex() {
        return logIndex;
    }

    public void setLogIndex(String logIndex) {
        this.logIndex = logIndex;
    }

    public String getReturnFlag() {
        return returnFlag;
    }

    public void setReturnFlag(String returnFlag) {
        this.returnFlag = returnFlag;
    }

    public String getPriceCurrency() {
        return priceCurrency;
    }

    public void setPriceCurrency(String priceCurrency) {
        this.priceCurrency = priceCurrency;
    }

    public String getVehicleClass() {
        return vehicleClass;
    }

    public void setVehicleClass(String vehicleClass) {
        this.vehicleClass = vehicleClass;
    }

    public String getSeqValidPayment() {
        return seqValidPayment;
    }

    public void setSeqValidPayment(String seqValidPayment) {
        this.seqValidPayment = seqValidPayment;
    }

    public String getSeqDetection() {
        return seqDetection;
    }

    public void setSeqDetection(String seqDetection) {
        this.seqDetection = seqDetection;
    }

    public String getSeqEnforce() {
        return seqEnforce;
    }

    public void setSeqEnforce(String seqEnforce) {
        this.seqEnforce = seqEnforce;
    }

    public String getSeqLcTransaction() {
        return seqLcTransaction;
    }

    public void setSeqLcTransaction(String seqLcTransaction) {
        this.seqLcTransaction = seqLcTransaction;
    }

    public String getSeqVideoPicture() {
        return seqVideoPicture;
    }

    public void setSeqVideoPicture(String seqVideoPicture) {
        this.seqVideoPicture = seqVideoPicture;
    }

    public String getSignalCodeBitmap() {
        return signalCodeBitmap;
    }

    public void setSignalCodeBitmap(String signalCodeBitmap) {
        this.signalCodeBitmap = signalCodeBitmap;
    }

    public String getLaneMode() {
        return laneMode;
    }

    public void setLaneMode(String laneMode) {
        this.laneMode = laneMode;
    }

    public String getLightSignalCode() {
        return lightSignalCode;
    }

    public void setLightSignalCode(String lightSignalCode) {
        this.lightSignalCode = lightSignalCode;
    }

    public String getExitAvc() {
        return exitAvc;
    }

    public void setExitAvc(String exitAvc) {
        this.exitAvc = exitAvc;
    }

    public String getExitAvcAxles() {
        return exitAvcAxles;
    }

    public void setExitAvcAxles(String exitAvcAxles) {
        this.exitAvcAxles = exitAvcAxles;
    }

    public String getExitAvcWheels() {
        return exitAvcWheels;
    }

    public void setExitAvcWheels(String exitAvcWheels) {
        this.exitAvcWheels = exitAvcWheels;
    }

    public String getExitAvcSensors() {
        return exitAvcSensors;
    }

    public void setExitAvcSensors(String exitAvcSensors) {
        this.exitAvcSensors = exitAvcSensors;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getUsageControl() {
        return usageControl;
    }

    public void setUsageControl(String usageControl) {
        this.usageControl = usageControl;
    }

    public String getEfccmCountry() {
        return efccmCountry;
    }

    public void setEfccmCountry(String efccmCountry) {
        this.efccmCountry = efccmCountry;
    }

    public String getEfccmIssuer() {
        return efccmIssuer;
    }

    public void setEfccmIssuer(String efccmIssuer) {
        this.efccmIssuer = efccmIssuer;
    }

    public String getEfccmTypeOfContract() {
        return efccmTypeOfContract;
    }

    public void setEfccmTypeOfContract(String efccmTypeOfContract) {
        this.efccmTypeOfContract = efccmTypeOfContract;
    }

    public String getEfccmContextVersion() {
        return efccmContextVersion;
    }

    public void setEfccmContextVersion(String efccmContextVersion) {
        this.efccmContextVersion = efccmContextVersion;
    }

    public String getRdSessionTime() {
        return rdSessionTime;
    }

    public void setRdSessionTime(String rdSessionTime) {
        this.rdSessionTime = rdSessionTime;
    }

    public String getRdSessionCountry() {
        return rdSessionCountry;
    }

    public void setRdSessionCountry(String rdSessionCountry) {
        this.rdSessionCountry = rdSessionCountry;
    }

    public String getRdSessionIssuer() {
        return rdSessionIssuer;
    }

    public void setRdSessionIssuer(String rdSessionIssuer) {
        this.rdSessionIssuer = rdSessionIssuer;
    }

    public String getRdSessionPlaza() {
        return rdSessionPlaza;
    }

    public void setRdSessionPlaza(String rdSessionPlaza) {
        this.rdSessionPlaza = rdSessionPlaza;
    }

    public String getRdSessionLane() {
        return rdSessionLane;
    }

    public void setRdSessionLane(String rdSessionLane) {
        this.rdSessionLane = rdSessionLane;
    }

    public String getRdSessionStationType() {
        return rdSessionStationType;
    }

    public void setRdSessionStationType(String rdSessionStationType) {
        this.rdSessionStationType = rdSessionStationType;
    }

    public String getRndRse() {
        return rndRse;
    }

    public void setRndRse(String rndRse) {
        this.rndRse = rndRse;
    }

    public String getKeyRef() {
        return keyRef;
    }

    public void setKeyRef(String keyRef) {
        this.keyRef = keyRef;
    }

    public String getObuAuthenticator() {
        return obuAuthenticator;
    }

    public void setObuAuthenticator(String obuAuthenticator) {
        this.obuAuthenticator = obuAuthenticator;
    }

    public String getPictureFileName() {
        return pictureFileName;
    }

    public void setPictureFileName(String pictureFileName) {
        this.pictureFileName = pictureFileName;
    }

    public String getIsHit() {
        return isHit;
    }

    public void setIsHit(String isHit) {
        this.isHit = isHit;
    }

    public Double getHitCounter() {
        return hitCounter;
    }

    public void setHitCounter(Double hitCounter) {
        this.hitCounter = hitCounter;
    }

    public Date getTimeStampTr() {
        return timeStampTr;
    }

    public void setTimeStampTr(Date timeStampTr) {
        this.timeStampTr = timeStampTr;
    }

    public Date getLastHitTimeStamp() {
        return lastHitTimeStamp;
    }

    public void setLastHitTimeStamp(Date lastHitTimeStamp) {
        this.lastHitTimeStamp = lastHitTimeStamp;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getShitDate() {
        return shitDate;
    }

    public void setShitDate(String shitDate) {
        this.shitDate = shitDate;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getUuidInput() {
        return uuidInput;
    }

    public void setUuidInput(String uuidInput) {
        this.uuidInput = uuidInput;
    }

    public String getIsRespon() {
        return isRespon;
    }

    public void setIsRespon(String isRespon) {
        this.isRespon = isRespon;
    }
}
