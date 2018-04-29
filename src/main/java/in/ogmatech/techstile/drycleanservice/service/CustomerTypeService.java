package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.CustomerType;

import java.util.List;

public interface CustomerTypeService {

    boolean isExist(CustomerType customerType);

    CustomerType save(CustomerType customerType);

    CustomerType findById(Long idCustomerType);

    List<CustomerType> findAll();

    CustomerType update(Long idCustomerType, CustomerType customerType);

    void delete(Long idCustomerType);

    void deleteAll();
}
