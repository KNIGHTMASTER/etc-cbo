package id.co.telkomsigma.etc.cbo.data.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created on 10/3/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class EventInputDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = -1713524303793105903L;

    private String eventTypeId;
    private String obuId;
    private String trxAmount;
    private String eventBeginTime;
    private String plazaCode;
    private String processingDate; //new Date
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
    private String hitCounter;
    private String timeStampTr;
    private String lastHitTimeStamp;
    private String shift;
    private String shitDate;
    private String balance;
    private String uuidInput;
    private String isRespon;
    private Date timestampLog;

    public Date getTimestampLog() {
        return timestampLog;
    }

    public void setTimestampLog(Date timestampLog) {
        this.timestampLog = timestampLog;
    }

    public String getObuId() {
        return obuId;
    }

    public void setObuId(String obuId) {
        this.obuId = obuId;
    }

    public String getPlazaCode() {
        return plazaCode;
    }

    public void setPlazaCode(String plazaCode) {
        this.plazaCode = plazaCode;
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

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
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

    public String getEventTypeId() {
        return eventTypeId;
    }

    public void setEventTypeId(String eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

    public String getTrxAmount() {
        return trxAmount;
    }

    public void setTrxAmount(String trxAmount) {
        this.trxAmount = trxAmount;
    }

    public String getEventBeginTime() {
        return eventBeginTime;
    }

    public void setEventBeginTime(String eventBeginTime) {
        this.eventBeginTime = eventBeginTime;
    }

    public String getProcessingDate() {
        return processingDate;
    }

    public void setProcessingDate(String processingDate) {
        this.processingDate = processingDate;
    }

    public String getHitCounter() {
        return hitCounter;
    }

    public void setHitCounter(String hitCounter) {
        this.hitCounter = hitCounter;
    }

    public String getTimeStampTr() {
        return timeStampTr;
    }

    public void setTimeStampTr(String timeStampTr) {
        this.timeStampTr = timeStampTr;
    }

    public String getLastHitTimeStamp() {
        return lastHitTimeStamp;
    }

    public void setLastHitTimeStamp(String lastHitTimeStamp) {
        this.lastHitTimeStamp = lastHitTimeStamp;
    }

    public String getShitDate() {
        return shitDate;
    }

    public void setShitDate(String shitDate) {
        this.shitDate = shitDate;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "EventInputDTO{" +
                "eventTypeId=" + eventTypeId +
                ", obuId='" + obuId + '\'' +
                ", trxAmount=" + trxAmount +
                ", eventBeginTime=" + eventBeginTime +
                ", plazaCode='" + plazaCode + '\'' +
                ", processingDate=" + processingDate +
                ", stationType='" + stationType + '\'' +
                ", lane='" + lane + '\'' +
                ", direction='" + direction + '\'' +
                ", dst='" + dst + '\'' +
                ", signalingCode='" + signalingCode + '\'' +
                ", manufactureId='" + manufactureId + '\'' +
                ", obuStatus='" + obuStatus + '\'' +
                ", signalingLevel='" + signalingLevel + '\'' +
                ", logIndex='" + logIndex + '\'' +
                ", returnFlag='" + returnFlag + '\'' +
                ", priceCurrency='" + priceCurrency + '\'' +
                ", vehicleClass='" + vehicleClass + '\'' +
                ", seqValidPayment='" + seqValidPayment + '\'' +
                ", seqDetection='" + seqDetection + '\'' +
                ", seqEnforce='" + seqEnforce + '\'' +
                ", seqLcTransaction='" + seqLcTransaction + '\'' +
                ", seqVideoPicture='" + seqVideoPicture + '\'' +
                ", signalCodeBitmap='" + signalCodeBitmap + '\'' +
                ", laneMode='" + laneMode + '\'' +
                ", lightSignalCode='" + lightSignalCode + '\'' +
                ", exitAvc='" + exitAvc + '\'' +
                ", exitAvcAxles='" + exitAvcAxles + '\'' +
                ", exitAvcWheels='" + exitAvcWheels + '\'' +
                ", exitAvcSensors='" + exitAvcSensors + '\'' +
                ", pan='" + pan + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", usageControl='" + usageControl + '\'' +
                ", efccmCountry='" + efccmCountry + '\'' +
                ", efccmIssuer='" + efccmIssuer + '\'' +
                ", efccmTypeOfContract='" + efccmTypeOfContract + '\'' +
                ", efccmContextVersion='" + efccmContextVersion + '\'' +
                ", rdSessionTime='" + rdSessionTime + '\'' +
                ", rdSessionCountry='" + rdSessionCountry + '\'' +
                ", rdSessionIssuer='" + rdSessionIssuer + '\'' +
                ", rdSessionPlaza='" + rdSessionPlaza + '\'' +
                ", rdSessionLane='" + rdSessionLane + '\'' +
                ", rdSessionStationType='" + rdSessionStationType + '\'' +
                ", rndRse='" + rndRse + '\'' +
                ", keyRef='" + keyRef + '\'' +
                ", obuAuthenticator='" + obuAuthenticator + '\'' +
                ", pictureFileName='" + pictureFileName + '\'' +
                ", isHit='" + isHit + '\'' +
                ", hitCounter=" + hitCounter +
                ", timeStampTr=" + timeStampTr +
                ", lastHitTimeStamp=" + lastHitTimeStamp +
                ", shift='" + shift + '\'' +
                ", shitDate=" + shitDate +
                ", balance=" + balance +
                ", uuidInput='" + uuidInput + '\'' +
                ", isRespon='" + isRespon + '\'' +
                '}';
    }
}
