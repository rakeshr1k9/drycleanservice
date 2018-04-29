package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.ServiceN;

import java.util.List;

public interface ServiceService {

    boolean isExist(ServiceN service);

    ServiceN save(ServiceN service);

    ServiceN findById(Long idService);

    List<ServiceN> findAll();

    ServiceN update(Long idService, ServiceN service);

    void delete(Long idService);

    void deleteAll();
}
