package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.ServiceType;

import java.util.List;

public interface ServiceTypeService {

    boolean isExist(ServiceType serviceType);

    ServiceType save(ServiceType serviceType);

    ServiceType findById(Long idServiceType);

    List<ServiceType> findAll();

    ServiceType update(Long idServiceType, ServiceType serviceType);

    void delete(Long idServiceType);

    void deleteAll();
}
