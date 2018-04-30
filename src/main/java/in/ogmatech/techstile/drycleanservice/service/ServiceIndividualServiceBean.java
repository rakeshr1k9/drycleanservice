package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.ServiceIndividual;
import in.ogmatech.techstile.drycleanservice.repository.ServiceIndividualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@Transactional
public class ServiceIndividualServiceBean implements ServiceIndividualService {

    @Autowired
    ServiceIndividualRepository serviceIndividualRepository;

    @Override
    public boolean isExist(ServiceIndividual serviceIndividual) {
        return findById(serviceIndividual.getIdServiceIndividual())!=null;
    }

    @Override
    public ServiceIndividual save(ServiceIndividual serviceIndividual) {
        return serviceIndividualRepository.save(serviceIndividual);
    }

    @Override
    public ServiceIndividual findById(Long idServiceIndividual) {
        return serviceIndividualRepository.findOne(idServiceIndividual);
    }

    @Override
    public List<ServiceIndividual> findAll() {
        return serviceIndividualRepository.findAll();
    }

    @Override
    public ServiceIndividual update(Long idServiceIndividual, ServiceIndividual serviceIndividual) {

        ServiceIndividual currentService = serviceIndividualRepository.findOne(idServiceIndividual);

       /* currentService.setServicename(service.getServicename());
        currentService.setPassword(service.getPassword());
        currentService.setServiceMobile(service.getServiceMobile());
        currentService.setIsDeleted(service.getIsDeleted());
        currentService.setBranchId(service.getBranchId());
        currentService.setServiceDeviceIdentity(service.getServiceDeviceIdentity());*/

        return serviceIndividualRepository.save(currentService);
    }

    @Override
    public void delete(Long idServiceIndividual) {
        serviceIndividualRepository.delete(idServiceIndividual);
    }

    @Override
    public void deleteAll() {
        serviceIndividualRepository.deleteAll();
    }
}
