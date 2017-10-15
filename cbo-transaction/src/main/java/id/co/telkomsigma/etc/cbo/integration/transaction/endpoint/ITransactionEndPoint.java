package id.co.telkomsigma.etc.cbo.integration.transaction.endpoint;

import id.co.telkomsigma.etc.cbo.data.dto.EventInputDTO;
import id.co.telkomsigma.etc.cbo.data.dto.response.ResponseDataHateoas;
import id.co.telkomsigma.etc.cbo.integration.transaction.ICBOTransactionConstant;
import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.dto.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created on 10/3/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Api(value = "Transaction End Point", description = "Transaction End Point")
@RequestMapping("/api/security/")
public interface ITransactionEndPoint {

    @ResponseBody
    @PostMapping(value = ICBOTransactionConstant.Path.CONDUCT_TRANSACTION, produces = TMFConstant.Common.APPLICATION_JSON)
    @ApiOperation(value = "Conduct", notes = "Conduct Transaction From Plaza to CBO", response = ResponseData.class)
    ResponseDataHateoas conductTransaction(@RequestBody EventInputDTO p_EventInputDTO);

    @ResponseBody
    @PostMapping(value = "/make", produces = TMFConstant.Common.APPLICATION_JSON)
    @ApiOperation(value = "Make", notes = "Make Transaction From Plaza to CBO", response = ResponseData.class)
    ResponseData makeTransaction(@RequestBody EventInputDTO p_EventInputDTO);
}
