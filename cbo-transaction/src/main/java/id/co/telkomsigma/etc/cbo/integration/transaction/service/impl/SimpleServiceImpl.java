package id.co.telkomsigma.etc.cbo.integration.transaction.service.impl;

import id.co.telkomsigma.etc.cbo.integration.transaction.service.ISimpleService;
import org.springframework.stereotype.Service;

/**
 * Created on 10/12/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class SimpleServiceImpl implements ISimpleService {
    @Override
    public void sayHello() {
        System.out.println("Hello World");
    }
}
