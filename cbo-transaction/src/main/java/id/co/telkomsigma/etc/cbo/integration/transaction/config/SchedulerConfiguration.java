package id.co.telkomsigma.etc.cbo.integration.transaction.config;

import id.co.telkomsigma.etc.cbo.integration.transaction.ICBOTransactionConstant.ApplicationContextName;
import id.co.telkomsigma.etc.cbo.integration.transaction.ICBOTransactionConstant.Scheduler;
import id.co.telkomsigma.etc.cbo.integration.transaction.ICBOTransactionConstant.Scheduler.JobDetailName;
import id.co.telkomsigma.etc.cbo.integration.transaction.ICBOTransactionConstant.Scheduler.TriggerName;
import id.co.telkomsigma.etc.cbo.integration.transaction.scheduler.SchedulerBalanceInfoLauncher;
import id.co.telkomsigma.etc.cbo.integration.transaction.scheduler.SchedulerQueryListLauncher;
import id.co.telkomsigma.tmf.batch.AutowiringSpringBeanJobFactory;
import org.quartz.CronTrigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Created on 7/27/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Configuration
@Order(7)
public class SchedulerConfiguration {

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Autowired
    private ApplicationContext applicationContext;

    @Value("${quartz.cron.expression.query.list}")
    private String cronExpressionQueryList;

    @Value("${quartz.cron.expression.balance.info}")
    private String cronExpressionBalanceInfo;

    /*============================================================================*/
    /*JOB DETAIL BLOCK*/
    /*============================================================================*/
    @Bean
    public JobDetailFactoryBean jobDetailQueryList() {
        JobDetailFactoryBean jobDetail = new JobDetailFactoryBean();
        jobDetail.setBeanName(JobDetailName.JOB_DETAIL_QUERY_LIST);
        jobDetail.setJobClass(SchedulerQueryListLauncher.class);
        jobDetail.setApplicationContext(applicationContext);
        jobDetail.setDurability(true);
        jobDetail.afterPropertiesSet();
        return jobDetail;
    }

    @Bean
    public JobDetailFactoryBean jobDetailBalanceInfo() {
        JobDetailFactoryBean jobDetail = new JobDetailFactoryBean();
        jobDetail.setBeanName(JobDetailName.JOB_DETAIL_BALANCE_INFO);
        jobDetail.setJobClass(SchedulerBalanceInfoLauncher.class);
        jobDetail.setApplicationContext(applicationContext);
        jobDetail.setDurability(true);
        jobDetail.afterPropertiesSet();
        return jobDetail;
    }

    /*============================================================================*/
    /*TRIGGER BLOCK*/
    /*============================================================================*/
    @Bean
    public CronTrigger triggerQueryList() throws Exception {
        CronTriggerFactoryBean cronTriggerBean = new CronTriggerFactoryBean();
        cronTriggerBean.setBeanName(TriggerName.TRIGGER_QUERY_LIST);
        cronTriggerBean.setJobDetail(jobDetailQueryList().getObject());
        cronTriggerBean.setCronExpression(cronExpressionQueryList);
        cronTriggerBean.afterPropertiesSet();
        return cronTriggerBean.getObject();
    }

    @Bean
    public CronTrigger triggerBalanceInfo() throws Exception {
        CronTriggerFactoryBean cronTriggerBean = new CronTriggerFactoryBean();
        cronTriggerBean.setBeanName(TriggerName.TRIGGER_BALANCE_INFO);
        cronTriggerBean.setJobDetail(jobDetailBalanceInfo().getObject());
        cronTriggerBean.setCronExpression(cronExpressionBalanceInfo);
        cronTriggerBean.afterPropertiesSet();
        return cronTriggerBean.getObject();
    }

    /*============================================================================*/
    /*SCHEDULER BLOCK*/
    /*============================================================================*/
    @Bean
    @ConditionalOnProperty(name = "scheduler.querylist.enabled", havingValue = "true", matchIfMissing = true)
    public SchedulerFactoryBean schedulerQueryList() throws Exception {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setTransactionManager(transactionManager);
        factory.setOverwriteExistingJobs(true);
        factory.setSchedulerName(Scheduler.Name.SCHEDULER_QUERY_LIST);

        AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
        jobFactory.setApplicationContext(applicationContext);
        factory.setJobFactory(jobFactory);

        factory.setApplicationContextSchedulerContextKey(ApplicationContextName.APPLICATION_CONTEXT_SCHEDULER);
        factory.setApplicationContext(applicationContext);

        factory.setTriggers(triggerQueryList());
        factory.setJobFactory(new SpringBeanJobFactory());

        factory.afterPropertiesSet();

        return factory;
    }

    @Bean
    @ConditionalOnProperty(name = "scheduler.balanceinfo.enabled", havingValue = "true", matchIfMissing = true)
    public SchedulerFactoryBean schedulerBalanceInfo() throws Exception {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setTransactionManager(transactionManager);
        factory.setOverwriteExistingJobs(true);
        factory.setSchedulerName(Scheduler.Name.SCHEDULER_BALANCE_INFO);

        AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
        jobFactory.setApplicationContext(applicationContext);
        factory.setJobFactory(jobFactory);

        factory.setApplicationContextSchedulerContextKey(ApplicationContextName.APPLICATION_CONTEXT_SCHEDULER);
        factory.setApplicationContext(applicationContext);

        factory.setTriggers(triggerBalanceInfo());
        factory.setJobFactory(new SpringBeanJobFactory());

        factory.afterPropertiesSet();

        return factory;
    }
}