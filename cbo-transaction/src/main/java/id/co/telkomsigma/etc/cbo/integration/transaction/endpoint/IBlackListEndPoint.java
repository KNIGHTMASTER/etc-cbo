package id.co.telkomsigma.etc.cbo.integration.transaction.endpoint;

import id.co.telkomsigma.etc.cbo.data.dto.request.blacklist.RequestBlackListDTO;
import id.co.telkomsigma.etc.cbo.data.dto.response.ResponseDataHateoas;
import id.co.telkomsigma.etc.cbo.integration.transaction.ICBOTransactionConstant;
import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.dto.ResponseData;
import id.co.telkomsigma.tmf.integration.exception.EndPointException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created on 12/18/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Api(value = "BlackList End Point", description = "BlackList End Point")
@RequestMapping("/api/security/")
public interface IBlackListEndPoint {

    @ResponseBody
    @PostMapping(value = ICBOTransactionConstant.Path.BLACKLIST, produces = TMFConstant.Common.APPLICATION_JSON)
    @ApiOperation(value = "blacklist", notes = "Set Blacklist from Obu Id", response = ResponseData.class)
    ResponseDataHateoas conductBlackList(@RequestBody RequestBlackListDTO p_RequestBlackListDTO) throws EndPointException;

}
