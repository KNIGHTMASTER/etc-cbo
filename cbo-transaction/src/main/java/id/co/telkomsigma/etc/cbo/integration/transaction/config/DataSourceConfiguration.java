package id.co.telkomsigma.etc.cbo.integration.transaction.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * Created on 10/17/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Configuration
@Order(8)
public class DataSourceConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    @ConditionalOnProperty(name = "datasource.hikari.enabled", havingValue = "true", matchIfMissing = true)
    HikariConfig hikariConfig(){
        return new HikariConfig();
    }

    @Bean
    @ConditionalOnProperty(name = "datasource.hikari.enabled", havingValue = "true", matchIfMissing = true)
    HikariDataSource hikariDataSource(){
        return new HikariDataSource(hikariConfig());
    }
}
