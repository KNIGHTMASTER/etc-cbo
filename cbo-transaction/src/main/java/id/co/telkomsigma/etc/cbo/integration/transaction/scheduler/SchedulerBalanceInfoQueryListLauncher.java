package id.co.telkomsigma.etc.cbo.integration.transaction.scheduler;

import id.co.telkomsigma.etc.cbo.integration.transaction.ICBOTransactionConstant.ApplicationContextName;
import id.co.telkomsigma.etc.cbo.integration.transaction.topic.StatusListTopicProducer;
import id.co.telkomsigma.etc.cbo.shared.data.StatusListContentDTO;
import id.co.telkomsigma.etc.cbo.shared.data.StatusListDTO;
import id.co.telkomsigma.tmf.batch.ASchedulerLauncher;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 10/12/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class SchedulerBalanceInfoQueryListLauncher extends ASchedulerLauncher {

    private static final Logger LOGGER = LoggerFactory.getLogger(SchedulerBalanceInfoQueryListLauncher.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        ApplicationContext appCtx = null;
        try {
            appCtx = (ApplicationContext) jobExecutionContext.getScheduler().getContext().get(ApplicationContextName.APPLICATION_CONTEXT_SCHEDULER);
        } catch (SchedulerException e) {
            LOGGER.error("Error injection application context ".concat(e.toString()));
        }
        LOGGER.info("Balance Info Query List Scheduler Started");
        /*IBalanceInfoQueryListService balanceInfoQueryListService = appCtx.getBean(IBalanceInfoQueryListService.class);
        balanceInfoQueryListService.conduct();*/

        StatusListDTO statusListDTO = new StatusListDTO();
        List<StatusListContentDTO> statusListContentDTOList = new ArrayList<>();
        StatusListContentDTO statusListContentDTO = new StatusListContentDTO();
        statusListContentDTO.setRecordType("rc");
        statusListContentDTO.setPan("pan");
        statusListContentDTO.setBalance("balance");
        statusListContentDTO.setStatusFlags("sf");
        statusListContentDTOList.add(statusListContentDTO);
        statusListDTO.setContents(statusListContentDTOList);

        StatusListTopicProducer statusListTopicProducer = appCtx.getBean(StatusListTopicProducer.class);
        statusListTopicProducer.send(statusListDTO);

        LOGGER.info("SCHEDULER HAS SENT STATUS LIST TO TOPIC CONSUMER");
    }
}
