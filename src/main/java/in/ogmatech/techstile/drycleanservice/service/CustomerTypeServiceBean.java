package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.CustomerType;
import in.ogmatech.techstile.drycleanservice.repository.CustomerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@Transactional
public class CustomerTypeServiceBean implements CustomerTypeService {

    @Autowired
    CustomerTypeRepository customerTypeRepository;
    
    @Override
    public boolean isExist(CustomerType customerType) {
        return findById(customerType.getIdCustomerType())!=null;
    }

    @Override
    public CustomerType save(CustomerType customerType) {
        return customerTypeRepository.save(customerType);
    }

    @Override
    public CustomerType findById(Long idCustomerType) {
        return customerTypeRepository.findOne(idCustomerType);
    }

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }

    @Override
    public CustomerType update(Long idCustomerType, CustomerType customerType) {

        CustomerType currentCustomerType = customerTypeRepository.findOne(idCustomerType);

       /* currentCustomerType.setCustomerTypename(customerType.getCustomerTypename());
        currentCustomerType.setPassword(customerType.getPassword());
        currentCustomerType.setCustomerTypeMobile(customerType.getCustomerTypeMobile());
        currentCustomerType.setIsDeleted(customerType.getIsDeleted());
        currentCustomerType.setBranchId(customerType.getBranchId());
        currentCustomerType.setCustomerTypeDeviceIdentity(customerType.getCustomerTypeDeviceIdentity());*/
      
        return customerTypeRepository.save(currentCustomerType);
    }

    @Override
    public void delete(Long idCustomerType) {
        customerTypeRepository.delete(idCustomerType);
    }

    @Override
    public void deleteAll() {
        customerTypeRepository.deleteAll();
    }
}
