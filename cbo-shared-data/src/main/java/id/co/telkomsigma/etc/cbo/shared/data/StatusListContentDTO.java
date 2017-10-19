package id.co.telkomsigma.etc.cbo.shared.data;

import java.io.Serializable;

/**
 * Created on 10/19/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class StatusListContentDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = 1933614794991896197L;

    private String recordType;
    private String pan;
    private String statusFlags;
    private String balance;

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getStatusFlags() {
        return statusFlags;
    }

    public void setStatusFlags(String statusFlags) {
        this.statusFlags = statusFlags;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "StatusListContentDTO{" +
                "recordType='" + recordType + '\'' +
                ", pan='" + pan + '\'' +
                ", statusFlags='" + statusFlags + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }
}
