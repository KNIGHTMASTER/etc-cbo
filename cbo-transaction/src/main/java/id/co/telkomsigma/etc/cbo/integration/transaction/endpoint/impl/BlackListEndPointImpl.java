package id.co.telkomsigma.etc.cbo.integration.transaction.endpoint.impl;

import id.co.telkomsigma.etc.cbo.data.dto.request.blacklist.RequestBlackListContentDTO;
import id.co.telkomsigma.etc.cbo.data.dto.request.blacklist.RequestBlackListDTO;
import id.co.telkomsigma.etc.cbo.data.dto.response.ResponseDataHateoas;
import id.co.telkomsigma.etc.cbo.data.model.SubBlackList;
import id.co.telkomsigma.etc.cbo.integration.transaction.endpoint.IBlackListEndPoint;
import id.co.telkomsigma.etc.cbo.integration.transaction.service.ISubBlackListService;
import id.co.telkomsigma.etc.cbo.integration.transaction.topic.BlackListTopicProducer;
import id.co.telkomsigma.etc.cbo.shared.data.BlackListContentDTO;
import id.co.telkomsigma.etc.cbo.shared.data.SharedBlackListDTO;
import id.co.telkomsigma.tmf.data.constant.EResponseCode;
import id.co.telkomsigma.tmf.data.dto.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static id.co.telkomsigma.etc.cbo.integration.transaction.ICBOTransactionConstant.Path.BLACKLIST;

/**
 * Created on 12/18/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
public class BlackListEndPointImpl implements IBlackListEndPoint {

    @Autowired
    private ISubBlackListService subBlackListService;

    @Autowired
    private BlackListTopicProducer blackListTopicProducer;

    private static final Logger LOGGER = LoggerFactory.getLogger(BlackListEndPointImpl.class);

    @Override
    public ResponseDataHateoas conductBlackList(@RequestBody RequestBlackListDTO p_RequestBlackListDTO) {
        ResponseDataHateoas responseDataHateoas = new ResponseDataHateoas();
        Link selfLink = ControllerLinkBuilder.linkTo(TransactionEndPointImpl.class).slash(BLACKLIST).withSelfRel();
        responseDataHateoas.add(selfLink);
        responseDataHateoas.setResponseData(new ResponseData(EResponseCode.RC_SUCCESS.getResponseCode(), EResponseCode.RC_SUCCESS.getResponseMsg()));
        if (p_RequestBlackListDTO != null) {
            if (p_RequestBlackListDTO.getBlackListContent() != null && p_RequestBlackListDTO.getBlackListContent().size() > 0) {
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    for (RequestBlackListContentDTO listContentDTO : p_RequestBlackListDTO.getBlackListContent()) {

                        /*Insert into Sub Black List Table*/
                        SubBlackList subBlackList = new SubBlackList();
                        subBlackList.seteMoneyId(listContentDTO.geteMoneyId());
                        subBlackList.setObuId(listContentDTO.getObuId());
                        subBlackList.setpSubscribtionStatusId(Integer.valueOf(listContentDTO.getpSubscriptionStatusId()));
                        subBlackList.setProductId(listContentDTO.getProductId());
                        subBlackList.setDataId(listContentDTO.getDataId());

                        subBlackList.setTransDate(sdf.parse(listContentDTO.getTransDate()));
                        subBlackList.setBlackListDateTime(new Date());
                        subBlackList.setSendStatus("N");
                        subBlackList.setBlackListTypeId(listContentDTO.getBlackListTypeId());
                        subBlackList.setReasonBl(listContentDTO.getReasonBl());
                        subBlackListService.insert(subBlackList);

                        List<SubBlackList> foundSubBlackLists = subBlackListService.findByObuIdAndSendStatus(listContentDTO.getObuId(), "N");
                        for (SubBlackList list : foundSubBlackLists) {
                            String selectedPan = subBlackListService.findPanByEMoneyId(list.geteMoneyId());
                            SharedBlackListDTO sharedBlackListDTO = new SharedBlackListDTO();
                            List<BlackListContentDTO> blackListContentDTOs = new ArrayList<>();
                            if (selectedPan != null) {
                                BlackListContentDTO blackListContentDTO = new BlackListContentDTO();
                                blackListContentDTO.setPan(selectedPan);
                                blackListContentDTO.setRecordType(list.getBlackListTypeId());

                                blackListContentDTOs.add(blackListContentDTO);
                            }
                            sharedBlackListDTO.setBlackListContentDTOs(blackListContentDTOs);
                            blackListTopicProducer.send(sharedBlackListDTO);

                            list.setSendStatus("Y");
                            subBlackListService.update(list);
                        }
                    }
                }catch (Exception e) {
                    LOGGER.error(e.toString());
                    responseDataHateoas.setResponseData(new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg()));
                }
            }else {
                responseDataHateoas.setResponseData(new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg()));
            }
        }else {
            responseDataHateoas.setResponseData(new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg()));
        }
        return responseDataHateoas;
    }
}
