package id.co.telkomsigma.etc.cbo.integration.transaction.scheduler;

import id.co.telkomsigma.etc.cbo.integration.transaction.ICBOTransactionConstant.ApplicationContextName;
import id.co.telkomsigma.etc.cbo.integration.transaction.service.IQueryListService;
import id.co.telkomsigma.tmf.batch.ASchedulerLauncher;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created on 10/12/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class SchedulerQueryListLauncher extends ASchedulerLauncher {

    private static final Logger LOGGER = LoggerFactory.getLogger(SchedulerQueryListLauncher.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        ApplicationContext appCtx = null;
        try {
            appCtx = (ApplicationContext) jobExecutionContext.getScheduler().getContext().get(ApplicationContextName.APPLICATION_CONTEXT_SCHEDULER);
        } catch (SchedulerException e) {
            LOGGER.error("Error injection application context ".concat(e.toString()));
        }
        LOGGER.info("Query List Scheduler Started");
        IQueryListService balanceInfoQueryListService = appCtx.getBean(IQueryListService.class);
        balanceInfoQueryListService.conductV2();
    }
}
