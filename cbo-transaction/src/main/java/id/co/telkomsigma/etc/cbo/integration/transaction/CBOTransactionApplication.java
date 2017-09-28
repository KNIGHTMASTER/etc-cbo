package id.co.telkomsigma.etc.cbo.integration.transaction;

import id.co.telkomsigma.etc.cbo.data.CBOConstant.PackageScanner.Cbo;
import id.co.telkomsigma.etc.cbo.data.CBOConstant.PackageScanner.Tmf;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created on 8/31/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@SpringBootApplication
@ComponentScan(value = {Tmf.COMPONENT_TMF, Cbo.COMPONENT_CBO})
@EnableAutoConfiguration
@EntityScan({Tmf.ENTITY_TMF, Cbo.ENTITY_CBO})
@EnableJpaRepositories({Tmf.DAO_TMF, Cbo.DAO_CBO})
public class CBOTransactionApplication {

    public static void main(String [] args){
        SpringApplication.run(CBOTransactionApplication.class, args);
    }
}
