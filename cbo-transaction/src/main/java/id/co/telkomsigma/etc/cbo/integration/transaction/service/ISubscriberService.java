package id.co.telkomsigma.etc.cbo.integration.transaction.service;

import id.co.telkomsigma.etc.cbo.data.model.Subscriber;
import id.co.telkomsigma.tmf.service.exception.ServiceException;
import id.co.telkomsigma.tmf.service.scaffolding.IScaffoldingService;

/**
 * Created on 10/10/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface ISubscriberService extends IScaffoldingService<Subscriber> {

    String findServiceNumberByPan(String p_Pan);

    Long countByServiceNo(String p_ServiceNo);

    Subscriber findByServiceNo(String p_ServiceNo);

    String findPanByServiceNo(String p_ServiceNo) throws ServiceException;
}
