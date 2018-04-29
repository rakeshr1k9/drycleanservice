package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.ServiceType;
import in.ogmatech.techstile.drycleanservice.repository.ServiceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@Transactional
public class ServiceTypeServiceBean implements ServiceTypeService {

    @Autowired
    ServiceTypeRepository serviceTypeRepository;

    @Override
    public boolean isExist(ServiceType serviceType) {
        return findById(serviceType.getIdServiceType())!=null;
    }

    @Override
    public ServiceType save(ServiceType serviceType) {
        return serviceTypeRepository.save(serviceType);
    }

    @Override
    public ServiceType findById(Long idServiceType) {
        return serviceTypeRepository.findOne(idServiceType);
    }

    @Override
    public List<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }

    @Override
    public ServiceType update(Long idServiceType, ServiceType serviceType) {

        ServiceType currentServiceType = serviceTypeRepository.findOne(idServiceType);

       /* currentServiceType.setServiceTypename(serviceType.getServiceTypename());
        currentServiceType.setPassword(serviceType.getPassword());
        currentServiceType.setServiceTypeMobile(serviceType.getServiceTypeMobile());
        currentServiceType.setIsDeleted(serviceType.getIsDeleted());
        currentServiceType.setBranchId(serviceType.getBranchId());
        currentServiceType.setServiceTypeDeviceIdentity(serviceType.getServiceTypeDeviceIdentity());*/

        return serviceTypeRepository.save(currentServiceType);
    }

    @Override
    public void delete(Long idServiceType) {
        serviceTypeRepository.delete(idServiceType);
    }

    @Override
    public void deleteAll() {
        serviceTypeRepository.deleteAll();
    }
}
