package id.co.telkomsigma.etc.cbo.integration.transaction.config;

import id.co.telkomsigma.etc.cbo.integration.transaction.ICBOTransactionConstant.JMS;
import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.constant.TMFConstant.JMS.TrustedPackages;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import java.util.ArrayList;
import java.util.List;

import static id.co.telkomsigma.etc.cbo.data.CBOConstant.PackageScanner.Cbo.COMPONENT_CBO;

/**
 * Created on 9/8/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Configuration
@EnableJms
@EnableAutoConfiguration
@Order(6)
public class CboTransactionJMSConfig {

    @Value("${jmx.listener.autostartup}")
    private String jmxAutoStartup;

    @Value("${spring.activemq.broker-url}")
    String activeMQBrokerUrl;

    @Value("${jms.listener.transaction.concurrency.size}")
    String transactionConcurrencySize;

    @Value("${jms.listener.statuslist.concurrency.size}")
    String statusListConcurrencySize;

    @Value("${jms.listener.blacklist.concurrency.size}")
    String blackListConcurrencySize;

    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory(){
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(activeMQBrokerUrl);
        List<String> trustedPackages = new ArrayList<>();
        trustedPackages.add(TrustedPackages.JAVA_LANG);
        trustedPackages.add(TrustedPackages.JAVA_MATH);
        trustedPackages.add(TrustedPackages.JAVA_UTIL);
        trustedPackages.add(TMFConstant.Common.BASE_PACKAGES);
        trustedPackages.add(COMPONENT_CBO);
        factory.setTrustedPackages(trustedPackages);
        return factory;
    }

    @Bean
    public JmsListenerContainerFactory<?> jmsTrxListenerContainerFactory() {
        DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
        defaultJmsListenerContainerFactory.setConcurrency(transactionConcurrencySize);
        defaultJmsListenerContainerFactory.setAutoStartup(Boolean.parseBoolean(jmxAutoStartup));
        defaultJmsListenerContainerFactory.setConnectionFactory(activeMQConnectionFactory());
        return defaultJmsListenerContainerFactory;
    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsStatusListTopicConnectionFactory(ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        factory.setPubSubDomain(true);
        factory.setConcurrency(statusListConcurrencySize);
        return factory;
    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsBlackListTopicConnectionFactory(ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        factory.setPubSubDomain(true);
        factory.setConcurrency(blackListConcurrencySize);
        return factory;
    }

    @Bean(name = JMS.Queue.QUEUE_TRX)
    public Queue queue() {
        return new ActiveMQQueue(JMS.Queue.QUEUE_TRX);
    }

}
