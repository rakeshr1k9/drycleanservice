package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.ServiceIndividual;

import java.util.List;

public interface ServiceIndividualService {

    boolean isExist(ServiceIndividual serviceIndividual);

    ServiceIndividual save(ServiceIndividual serviceIndividual);

    ServiceIndividual findById(Long idServiceIndividual);

    List<ServiceIndividual> findAll();

    ServiceIndividual update(Long idServiceIndividual, ServiceIndividual serviceIndividual);

    void delete(Long idServiceIndividual);

    void deleteAll();
}
