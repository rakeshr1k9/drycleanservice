package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.exception.AlreadyExistsException;
import in.ogmatech.techstile.drycleanservice.model.Customer;
import in.ogmatech.techstile.drycleanservice.model.Customer;
import in.ogmatech.techstile.drycleanservice.repository.CustomerRepository;
import in.ogmatech.techstile.drycleanservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@Transactional
public class CustomerServiceBean implements CustomerService{

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
    public Customer findById(Long idCustomer) {
        return customerRepository.findOne(idCustomer);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer update(Long idCustomer, Customer customer) {

        Customer currentCustomer = customerRepository.findOne(idCustomer);

       /* currentCustomer.setCustomername(customer.getCustomername());
        currentCustomer.setPassword(customer.getPassword());
        currentCustomer.setCustomerMobile(customer.getCustomerMobile());
        currentCustomer.setIsDeleted(customer.getIsDeleted());
        currentCustomer.setBranchId(customer.getBranchId());
        currentCustomer.setCustomerDeviceIdentity(customer.getCustomerDeviceIdentity());*/
       /* if (!entityManager.contains(customer))
            customer = entityManager.merge(customer);*/
        return customerRepository.save(currentCustomer);
    }

    @Override
    public void delete(Long idCustomer) {
        customerRepository.delete(idCustomer);
    }

    @Override
    public void deleteAll() {
        customerRepository.deleteAll();
    }
}
