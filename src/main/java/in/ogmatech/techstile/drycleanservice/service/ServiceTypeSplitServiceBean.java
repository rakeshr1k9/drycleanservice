package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.ServiceTypeSplit;
import in.ogmatech.techstile.drycleanservice.repository.ServiceTypeSplitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@Transactional
public class ServiceTypeSplitServiceBean implements ServiceTypeSplitService {

    @Autowired
    ServiceTypeSplitRepository serviceTypeSplitRepository;

    @Override
    public boolean isExist(ServiceTypeSplit serviceTypeSplit) {
        return findById(serviceTypeSplit.getIdServiceTypeSplit())!=null;
    }

    @Override
    public ServiceTypeSplit save(ServiceTypeSplit serviceTypeSplit) {
        return serviceTypeSplitRepository.save(serviceTypeSplit);
    }

    @Override
    public ServiceTypeSplit findById(Long idServiceTypeSplit) {
        return serviceTypeSplitRepository.findOne(idServiceTypeSplit);
    }

    @Override
    public List<ServiceTypeSplit> findAll() {
        return serviceTypeSplitRepository.findAll();
    }

    @Override
    public ServiceTypeSplit update(Long idServiceTypeSplit, ServiceTypeSplit serviceTypeSplit) {

        ServiceTypeSplit currentServiceTypeSplit = serviceTypeSplitRepository.findOne(idServiceTypeSplit);

       /* currentServiceTypeSplit.setServiceTypeSplitname(serviceTypeSplit.getServiceTypeSplitname());
        currentServiceTypeSplit.setPassword(serviceTypeSplit.getPassword());
        currentServiceTypeSplit.setServiceTypeSplitMobile(serviceTypeSplit.getServiceTypeSplitMobile());
        currentServiceTypeSplit.setIsDeleted(serviceTypeSplit.getIsDeleted());
        currentServiceTypeSplit.setBranchId(serviceTypeSplit.getBranchId());
        currentServiceTypeSplit.setServiceTypeSplitDeviceIdentity(serviceTypeSplit.getServiceTypeSplitDeviceIdentity());*/

        return serviceTypeSplitRepository.save(currentServiceTypeSplit);
    }

    @Override
    public void delete(Long idServiceTypeSplit) {
        serviceTypeSplitRepository.delete(idServiceTypeSplit);
    }

    @Override
    public void deleteAll() {
        serviceTypeSplitRepository.deleteAll();
    }
}
