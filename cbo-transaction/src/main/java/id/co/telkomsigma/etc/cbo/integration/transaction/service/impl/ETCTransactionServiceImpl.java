package id.co.telkomsigma.etc.cbo.integration.transaction.service.impl;

import id.co.telkomsigma.etc.cbo.data.CBOConstant.Query;
import id.co.telkomsigma.etc.cbo.data.CBOConstant.TRX;
import id.co.telkomsigma.etc.cbo.data.dto.EventInputDTO;
import id.co.telkomsigma.etc.cbo.data.dto.EventInputMapper;
import id.co.telkomsigma.etc.cbo.data.dto.EventInputMapperParamDTO;
import id.co.telkomsigma.etc.cbo.data.dto.param.PlazaNameParamDTO;
import id.co.telkomsigma.etc.cbo.data.dto.request.chargebatch.*;
import id.co.telkomsigma.etc.cbo.data.dto.response.ChargeResponseDTO;
import id.co.telkomsigma.etc.cbo.data.model.EventInput;
import id.co.telkomsigma.etc.cbo.data.model.LogTrxCBO;
import id.co.telkomsigma.etc.cbo.integration.transaction.client.ChargeBatchStartClient;
import id.co.telkomsigma.etc.cbo.integration.transaction.service.*;
import id.co.telkomsigma.etc.cbo.integration.transaction.util.UUIDGenerator;
import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.service.exception.ServiceException;
import id.co.telkomsigma.tmf.util.common.time.FormatDateConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static id.co.telkomsigma.etc.cbo.integration.transaction.ICBOTransactionConstant.TransactionCode.TRX_EVENT_TYPE_ID;

/**
 * Created on 10/4/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class ETCTransactionServiceImpl implements IETCTransactionService {

    @Autowired
    private IEventInputService eventInputService;

    @Autowired
    private EventInputMapper eventInputMapper;

    @Autowired
    private ChargeBatchStartClient chargeBatchStartClient;

    @Autowired
    private ISubscriberService subscriberService;

    @Autowired
    private IPlazaService plazaService;

    @Autowired
    ILogTrxCboService logTrxCboService;

    @Value("${cellum.merchantid}")
    private String cellumMerchantId;

    @Value("${cellum.terminalid}")
    private String cellumTerminalId;

    @Value("${cellum.apptypeid}")
    private String cellumAppTypeId;

    private EventInputMapperParamDTO eventInputMapperParamDTO;

    private static final Logger LOGGER = LoggerFactory.getLogger(ETCTransactionServiceImpl.class);

    @Transactional
    @Override
    public void conductTransaction(EventInputDTO p_EventInputDTO) {
        try {
            insertEventInput(p_EventInputDTO);
            insertLog(p_EventInputDTO, "Insert into event input table", 2);
        } catch (ServiceException e) {
            LOGGER.error("Failed insert event input "+e.toString());
        }
        hitChargeBatchStartAPI(eventInputMapperParamDTO.getUuid());
        insertLog(p_EventInputDTO, "Hit Charge Batch Start", 3);
    }

    @Override
    public void insertEventInput(EventInputDTO p_EventInputDTO) throws ServiceException {
        p_EventInputDTO.setEventTypeId(TRX_EVENT_TYPE_ID);

        eventInputMapperParamDTO = new EventInputMapperParamDTO();
        eventInputMapperParamDTO.setSimpleDateFormat(FormatDateConstant.DEFAULT2);
        eventInputMapperParamDTO.setUuid(UUIDGenerator.generate());
        eventInputMapper.setParam(eventInputMapperParamDTO);

        eventInputService.insert(eventInputMapper.convert(p_EventInputDTO));
    }

    @Override
    public void hitChargeBatchStartAPI() {
        List<EventInput> eventInputs = null;
        try {
            eventInputs = eventInputService.findByIsHit(Query.IS_HIT_NEW);
        } catch (ServiceException e) {
            LOGGER.error("Failed to find all event inputs "+e.toString());
        }
        ChargeRequestDTO chargeRequestDTO = buildRequestHitCharge(eventInputs);
        /*runRestClient(chargeRequestDTO);*/
    }

    private void insertLog(EventInputDTO eventInputDTO, String p_Description, int p_Status) {
        LogTrxCBO logTrxCBO = new LogTrxCBO();
        logTrxCBO.setCode(FormatDateConstant.ISO8601.format(eventInputDTO.getTimestampLog()));
        logTrxCBO.setLogDate(new Date());
        logTrxCBO.setRequestBody(eventInputDTO.toString());
        logTrxCBO.setDescription(p_Description);
        logTrxCBO.setStatus(p_Status);

        logTrxCboService.insert(logTrxCBO);
    }

    @Override
    public void hitChargeBatchStartAPI(String p_Id) {
        EventInput foundEventInput = eventInputService.findByUuidInput(p_Id);
        List<EventInput> eventInputs = new ArrayList<>();
        eventInputs.add(foundEventInput);
        if (foundEventInput != null) {
            ChargeRequestDTO chargeRequestDTO = buildRequestHitCharge(eventInputs);
            /*runRestClient(chargeRequestDTO);*/
        }
    }


    @Override
    public ChargeRequestDTO buildRequestHitCharge(List<EventInput> p_EventInputList) {
        ChargeRequestDTO chargeRequestDTO = new ChargeRequestDTO();
        List<ChargeRequestContentDTO> chargeRequestContentDTOs = new ArrayList<>();
        chargeRequestDTO.setChargeRequests(chargeRequestContentDTOs);
        if (p_EventInputList.size() > 0) {
            for (EventInput eventInput : p_EventInputList) {
                chargeRequestContentDTOs.add(buildContentRequestHitCharge(eventInput));
            }
        } else {
            EventInput eventInput = p_EventInputList.get(0);
            chargeRequestContentDTOs.add(buildContentRequestHitCharge(eventInput));
        }
        return chargeRequestDTO;
    }

    public ChargeRequestContentDTO buildContentRequestHitCharge(EventInput eventInput) {
        ChargeRequestContentDTO chargeRequestContentDTO = new ChargeRequestContentDTO();
        chargeRequestContentDTO.setExternalId(eventInput.getUuidInput());

        MerchantDTO merchantDTO = new MerchantDTO();
        merchantDTO.setMerchantId(Integer.parseInt(cellumMerchantId));
        merchantDTO.setTerminalId(Integer.parseInt(cellumTerminalId));
        chargeRequestContentDTO.setMerchant(merchantDTO);

        UserDTO userDTO = new UserDTO();
        userDTO.setAccountId(subscriberService.findServiceNumberByPan(eventInput.getPan()));
        userDTO.setAppTypeId(Integer.parseInt(cellumAppTypeId));
        chargeRequestContentDTO.setUser(userDTO);

        ChargeDTO chargeDTO = new ChargeDTO();
        chargeDTO.setAmount(eventInput.getTrxAmount());
        chargeDTO.setCommissionFee(BigDecimal.ONE);
        chargeDTO.setDescription("JM Gate Kapuk");

        PlazaNameParamDTO plazaNameParamDTO = plazaService.findPlazaNameByPlazaCode(eventInput.getPlazaCode());

        List<ReferencesDTO> referencesDTOList = new ArrayList<>();

        ReferencesDTO referenceRowId = new ReferencesDTO();
        referenceRowId.setKey(TRX.TB_ROWID);
        referenceRowId.setValue(eventInput.getUuidInput());
        referencesDTOList.add(referenceRowId);

        ReferencesDTO referencePan = new ReferencesDTO();
        referencePan.setKey(TRX.PAN);
        referencePan.setValue(eventInput.getPan());
        referencesDTOList.add(referencePan);

        ReferencesDTO referenceIDCID = new ReferencesDTO();
        referenceIDCID.setKey(TRX.IDC_ID);
        referenceIDCID.setValue(String.valueOf(eventInput.getInputDataControlId()));
        referencesDTOList.add(referenceIDCID);

        ReferencesDTO referencePlazaCode = new ReferencesDTO();
        referencePlazaCode.setKey(TRX.PLAZA_CODE);
        referencePlazaCode.setValue(eventInput.getPlazaCode());
        referencesDTOList.add(referencePlazaCode);

        ReferencesDTO referencePlazaName = new ReferencesDTO();
        referencePlazaName.setKey(TRX.PLAZA_NAME);
        referencePlazaName.setValue(plazaNameParamDTO.getPlazaName());
        referencesDTOList.add(referencePlazaName);

        ReferencesDTO referenceGateCode = new ReferencesDTO();
        referenceGateCode.setKey(TRX.GATE_CODE);
        referenceGateCode.setValue(eventInput.getLane());
        referencesDTOList.add(referenceGateCode);

        ReferencesDTO referenceShiftCode = new ReferencesDTO();
        referenceShiftCode.setKey(TRX.SHIFT_CODE);
        referenceShiftCode.setValue(eventInput.getShift());
        referencesDTOList.add(referenceShiftCode);

        ReferencesDTO referenceShiftDate = new ReferencesDTO();
        referenceShiftDate.setKey(TRX.SHIFT_DATE);
        referenceShiftDate.setValue(FormatDateConstant.DEFAULT3.format(eventInput.getShiftDate()));
        referencesDTOList.add(referenceShiftDate);

        ReferencesDTO referenceObuTrx = new ReferencesDTO();
        referenceObuTrx.setKey(TRX.OBUTRXTIME);
        referenceObuTrx.setValue(FormatDateConstant.DEFAULT4.format(eventInput.getEventBeginTime()));
        referencesDTOList.add(referenceObuTrx);

        chargeDTO.setReferences(referencesDTOList);
        chargeRequestContentDTO.setCharge(chargeDTO);

        return chargeRequestContentDTO;
    }

    @Override
    public void runRestClient(ChargeRequestDTO p_ChargeRequestDTO) {
        ChargeResponseDTO chargeResponseDTO = chargeBatchStartClient.queryClient(null, p_ChargeRequestDTO);
        if (chargeResponseDTO.getResultCode().equals(TMFConstant.Common.GeneralValue.OK)) {
            LOGGER.info("Success Hit Charge Batch Start");
        }else {
            LOGGER.error("Failed Hit Charge Batch Start");
        }
    }}
