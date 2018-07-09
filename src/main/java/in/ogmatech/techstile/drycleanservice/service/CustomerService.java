package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    boolean isExist(Customer customer);

    Customer save(Customer customer);

    Customer findById(Integer idCustomer);

    List<Customer> findAll();

    Customer update(Integer idCustomer, Customer customer);

    void delete(Integer idCustomer);

    void deleteAll();
}
