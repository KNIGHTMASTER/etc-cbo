package id.co.telkomsigma.etc.cbo.integration.transaction;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 8/31/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
@RequestMapping("/public")
public class GreetingEndPoint {

    @GetMapping("/hello")
    public String helloWorld(){
        System.out.println("Oke");
        return "Hello World CBO";
    }
}
