package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.ServiceN;
import in.ogmatech.techstile.drycleanservice.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@Transactional
public class ServiceServiceBean implements ServiceService{

    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public boolean isExist(ServiceN service) {
        return findById(service.getIdService())!=null;
    }

    @Override
    public ServiceN save(ServiceN service) {
        return serviceRepository.save(service);
    }

    @Override
    public ServiceN findById(Long idService) {
        return serviceRepository.findOne(idService);
    }

    @Override
    public List<ServiceN> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public ServiceN update(Long idService, ServiceN service) {

        ServiceN currentService = serviceRepository.findOne(idService);

       /* currentService.setServicename(service.getServicename());
        currentService.setPassword(service.getPassword());
        currentService.setServiceMobile(service.getServiceMobile());
        currentService.setIsDeleted(service.getIsDeleted());
        currentService.setBranchId(service.getBranchId());
        currentService.setServiceDeviceIdentity(service.getServiceDeviceIdentity());*/

        return serviceRepository.save(currentService);
    }

    @Override
    public void delete(Long idService) {
        serviceRepository.delete(idService);
    }

    @Override
    public void deleteAll() {
        serviceRepository.deleteAll();
    }
}
