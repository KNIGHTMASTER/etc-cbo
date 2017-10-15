package id.co.telkomsigma.etc.cbo.integration.transaction.endpoint;

import id.co.telkomsigma.etc.cbo.data.dto.EventInputDTO;
import id.co.telkomsigma.etc.cbo.data.dto.response.ResponseDataHateoas;
import id.co.telkomsigma.etc.cbo.data.model.LogTrxCBO;
import id.co.telkomsigma.etc.cbo.integration.transaction.queue.TransactionQueueProducer;
import id.co.telkomsigma.etc.cbo.integration.transaction.service.IETCTransactionService;
import id.co.telkomsigma.etc.cbo.integration.transaction.service.ILogTrxCboService;
import id.co.telkomsigma.tmf.data.constant.EResponseCode;
import id.co.telkomsigma.tmf.data.dto.ResponseData;
import id.co.telkomsigma.tmf.service.exception.ServiceException;
import id.co.telkomsigma.tmf.util.common.time.FormatDateConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import static id.co.telkomsigma.etc.cbo.integration.transaction.ICBOTransactionConstant.Path.CONDUCT_TRANSACTION;

/**
 * Created on 10/3/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
public class TransactionEndPointImpl implements ITransactionEndPoint {

    @Autowired
    TransactionQueueProducer transactionQueueProducer;

    @Autowired
    IETCTransactionService transactionService;

    @Autowired
    ILogTrxCboService logTrxCboService;

    @Override
    public ResponseDataHateoas conductTransaction(@RequestBody EventInputDTO p_EventInputDTO) {
        Link selfLink = ControllerLinkBuilder.linkTo(TransactionEndPointImpl.class).slash(CONDUCT_TRANSACTION).withSelfRel();
        Date timestampLog = new Date();
        p_EventInputDTO.setTimestampLog(timestampLog);
        insertLog(p_EventInputDTO);
        transactionQueueProducer.send(p_EventInputDTO);
        ResponseData responseData = new ResponseData(EResponseCode.RC_SUCCESS.getResponseCode(), EResponseCode.RC_SUCCESS.getResponseMsg());
        ResponseDataHateoas responseDataHateoas = new ResponseDataHateoas();
        responseDataHateoas.setResponseData(responseData);
        responseDataHateoas.add(selfLink);
        return responseDataHateoas;
    }

    @Override
    public ResponseData makeTransaction(@RequestBody EventInputDTO p_EventInputDTO) {
        p_EventInputDTO.setEventTypeId("118");
        try {
            transactionService.conductTransaction(p_EventInputDTO);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return new ResponseData(EResponseCode.RC_SUCCESS.getResponseCode(), EResponseCode.RC_SUCCESS.getResponseMsg());
    }

    private void insertLog(EventInputDTO p_EventInputDTO) {
        LogTrxCBO logTrxCBO = new LogTrxCBO();
        logTrxCBO.setCode(FormatDateConstant.ISO8601.format(p_EventInputDTO.getTimestampLog()));
        logTrxCBO.setLogDate(p_EventInputDTO.getTimestampLog());
        logTrxCBO.setRequestBody(p_EventInputDTO.toString());
        logTrxCBO.setDescription("Start insert into Rest Trx CBO");
        logTrxCBO.setStatus(1);

        logTrxCboService.insert(logTrxCBO);
    }
}
