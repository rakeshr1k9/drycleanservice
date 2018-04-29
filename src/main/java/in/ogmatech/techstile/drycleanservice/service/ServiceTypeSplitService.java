package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.ServiceTypeSplit;

import java.util.List;

public interface ServiceTypeSplitService {

    boolean isExist(ServiceTypeSplit serviceTypeSplit);

    ServiceTypeSplit save(ServiceTypeSplit serviceTypeSplit);

    ServiceTypeSplit findById(Long idServiceTypeSplit);

    List<ServiceTypeSplit> findAll();

    ServiceTypeSplit update(Long idServiceTypeSplit, ServiceTypeSplit serviceTypeSplit);

    void delete(Long idServiceTypeSplit);

    void deleteAll();
}
