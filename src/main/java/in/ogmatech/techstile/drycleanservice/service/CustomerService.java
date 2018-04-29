package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.Customer;

import java.util.List;

public interface CustomerService {

    boolean isExist(Customer customer);

    Customer save(Customer customer);

    Customer findById(Long idCustomer);

    List<Customer> findAll();

    Customer update(Long idCustomer, Customer customer);

    void delete(Long idCustomer);

    void deleteAll();
}
