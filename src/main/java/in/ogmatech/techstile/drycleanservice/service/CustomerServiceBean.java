package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.Customer;
import in.ogmatech.techstile.drycleanservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
@Validated
@Transactional
public class CustomerServiceBean implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

   /* @PersistenceContext
    private EntityManager entityManager;*/

    @Override
    public boolean isExist(Customer customer) {
        return findById(customer.getIdCustomer())!=null;
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer findById(Integer idCustomer) {
         return customerRepository.findById(idCustomer).orElse(null);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer update(Integer idCustomer, Customer customer) {

        Customer currentCustomer = customerRepository.findById(idCustomer).orElse(null);

       /* currentCustomer.setCustomername(customer.getCustomername());
        currentCustomer.setPassword(customer.getPassword());
        currentCustomer.setCustomerMobile(customer.getCustomerMobile());
        currentCustomer.setIsDeleted(customer.getIsDeleted());
        currentCustomer.setBranchId(customer.getBranchId());
        currentCustomer.setCustomerDeviceIdentity(customer.getCustomerDeviceIdentity());*/
       /* if (!entityManager.contains(customer))
            customer = entityManager.merge(customer);*/
       if(currentCustomer != null){
           return customerRepository.save(currentCustomer);
       }
       return null;
    }

    @Override
    public void delete(Integer idCustomer) {
        customerRepository.deleteById(idCustomer);
    }

    @Override
    public void deleteAll() {
        customerRepository.deleteAll();
    }
}
