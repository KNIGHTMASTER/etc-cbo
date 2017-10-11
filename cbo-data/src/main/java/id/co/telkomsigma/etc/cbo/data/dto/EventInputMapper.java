package id.co.telkomsigma.etc.cbo.data.dto;

import id.co.telkomsigma.etc.cbo.data.model.EventInput;
import id.co.telkomsigma.tmf.data.mapper.ADATAMapper;
import id.co.telkomsigma.tmf.data.param.IParameterizedComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created on 10/3/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class EventInputMapper extends ADATAMapper<EventInputDTO, EventInput> implements IParameterizedComponent<EventInputMapperParamDTO> {

    private EventInputMapperParamDTO eventInputMapperParamDTO;

    private static final Logger LOGGER = LoggerFactory.getLogger(EventInputMapper.class);

    @Override
    public EventInput convert(EventInputDTO p_EventInputDTO) {
        EventInput input = new EventInput();
        input.setInputDataControlId(null);
        input.setJobControlId(null);
        input.setEventTypeId(Integer.valueOf(p_EventInputDTO.getEventTypeId()));
        input.setWalletId(null);
        input.setObuId(p_EventInputDTO.getObuId());
        input.setTrxRefferenceCode(null);
        input.setTrxAmount(BigDecimal.valueOf(Long.valueOf(p_EventInputDTO.getTrxAmount())));
        input.setDrcr(null);
        try {
            input.setEventBeginTime(eventInputMapperParamDTO.getSimpleDateFormat().parse(p_EventInputDTO.getEventBeginTime()));
        } catch (Exception e) {
            LOGGER.error("Failed parsing String event begin time to Date "+e.toString());
        }
        input.setEventEndTime(null);
        input.setGateCode(null);
        input.setPlazaCode(p_EventInputDTO.getPlazaCode());
        input.setOperatorCode(null);
        input.setProcessingDate(new Date());
        input.setStationType(p_EventInputDTO.getStationType());
        input.setLane(p_EventInputDTO.getLane());
        input.setDirection(p_EventInputDTO.getDirection());
        input.setDst(p_EventInputDTO.getDst());
        input.setSignalingCode(p_EventInputDTO.getSignalingCode());
        input.setManufactureId(p_EventInputDTO.getManufactureId());
        input.setObuStatus(p_EventInputDTO.getObuStatus());
        input.setSignalingLevel(p_EventInputDTO.getSignalingLevel());
        input.setLogIndex(p_EventInputDTO.getLogIndex());
        input.setReturnFlag(p_EventInputDTO.getReturnFlag());
        input.setPriceCurrency(p_EventInputDTO.getPriceCurrency());
        input.setVehicleClass(p_EventInputDTO.getVehicleClass());
        input.setSeqValidPayment(p_EventInputDTO.getSeqValidPayment());
        input.setSeqDetection(p_EventInputDTO.getSeqDetection());
        input.setSeqEnforce(p_EventInputDTO.getSeqEnforce());
        input.setSeqLcTransaction(p_EventInputDTO.getSeqLcTransaction());
        input.setSeqVideoPicture(p_EventInputDTO.getSeqVideoPicture());
        input.setSignalCodeBitmap(p_EventInputDTO.getSignalCodeBitmap());
        input.setLaneMode(p_EventInputDTO.getLaneMode());
        input.setLightSignalCode(p_EventInputDTO.getLightSignalCode());
        input.setExitAvc(p_EventInputDTO.getExitAvc());
        input.setExitAvcAxles(p_EventInputDTO.getExitAvcAxles());
        input.setExitAvcWheels(p_EventInputDTO.getExitAvcWheels());
        input.setExitAvcSensors(p_EventInputDTO.getExitAvcSensors());
        input.setPan(p_EventInputDTO.getPan());
        input.setExpiryDate(p_EventInputDTO.getExpiryDate());
        input.setUsageControl(p_EventInputDTO.getUsageControl());
        input.setEfccmCountry(p_EventInputDTO.getEfccmCountry());
        input.setEfccmIssuer(p_EventInputDTO.getEfccmIssuer());
        input.setEfccmTypeOfContract(p_EventInputDTO.getEfccmTypeOfContract());
        input.setEfccmContextVersion(p_EventInputDTO.getEfccmContextVersion());
        input.setRdSessionTime(p_EventInputDTO.getRdSessionTime());
        input.setRdSessionCountry(p_EventInputDTO.getRdSessionCountry());
        input.setRdSessionIssuer(p_EventInputDTO.getRdSessionIssuer());
        input.setRdSessionPlaza(p_EventInputDTO.getRdSessionPlaza());
        input.setRdSessionLane(p_EventInputDTO.getRdSessionLane());
        input.setRdSessionStationType(p_EventInputDTO.getRdSessionStationType());
        input.setRndRse(p_EventInputDTO.getRndRse());
        input.setKeyRef(p_EventInputDTO.getKeyRef());
        input.setObuAuthenticator(p_EventInputDTO.getObuAuthenticator());
        input.setPictureFileName(p_EventInputDTO.getPictureFileName());
        input.setIsHit("N");
        try {
            input.setTimeStampTr(eventInputMapperParamDTO.getSimpleDateFormat().parse(p_EventInputDTO.getTimeStampTr()));
        } catch (ParseException e) {
            LOGGER.error("Error parsing text Timestamp Tr to Object Date "+e.toString());
        }
        input.setShift(p_EventInputDTO.getShift());
        try {
            input.setShiftDate(new SimpleDateFormat("yyyyMMdd").parse(p_EventInputDTO.getShitDate()));
        } catch (ParseException e) {
            LOGGER.error("Error parsing text Shift Date to Object Date "+e.toString());
        }
        input.setBalance(BigDecimal.valueOf(Long.valueOf(p_EventInputDTO.getBalance())));
        input.setUuidInput(eventInputMapperParamDTO.getUuid());
        return input;
    }

    @Override
    public void setParam(EventInputMapperParamDTO eventInputMapperParamDTO) {
        this.eventInputMapperParamDTO = eventInputMapperParamDTO;
    }

    @Override
    public EventInputMapperParamDTO getParam() {
        return eventInputMapperParamDTO;
    }
}
