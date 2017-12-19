package id.co.telkomsigma.etc.cbo.shared.data;

import java.io.Serializable;

/**
 * Created on 12/18/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class BlackListContentDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = 5563245239449633142L;

    private String recordType;
    private String pan;

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

    @Override
    public String toString() {
        return "BlackListContentDTO{" +
                "recordType='" + recordType + '\'' +
                ", pan='" + pan + '\'' +
                '}';
    }
}
