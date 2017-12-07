package id.co.telkomsigma.etc.cbo.data.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import id.co.telkomsigma.etc.cbo.data.dto.response.balanceinfo.BalanceInfoQueryListItemDTO;

import java.io.Serializable;

/**
 * Created on 11/7/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class ChargeProsesStatusContentDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = 345654917002776233L;

    private String externalId;
    private String cmnId;
    private String processStatus;
    private String resultCode;
    private String startDate;
    private String transferDate;
    private BalanceInfoQueryListItemDTO balanceInfo;

    @JsonProperty("ExternalId")
    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    @JsonProperty("CmnId")
    public String getCmnId() {
        return cmnId;
    }

    public void setCmnId(String cmnId) {
        this.cmnId = cmnId;
    }

    @JsonProperty("ProcessStatus")
    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus;
    }

    @JsonProperty("ResultCode")
    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    @JsonProperty("StartDate")
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @JsonProperty("TransferDate")
    public String getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(String transferDate) {
        this.transferDate = transferDate;
    }

    @JsonProperty("BalanceInfo")
    public BalanceInfoQueryListItemDTO getBalanceInfo() {
        return balanceInfo;
    }

    public void setBalanceInfo(BalanceInfoQueryListItemDTO balanceInfo) {
        this.balanceInfo = balanceInfo;
    }
}
