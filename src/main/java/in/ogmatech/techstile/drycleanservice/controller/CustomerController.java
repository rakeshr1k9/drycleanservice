package in.ogmatech.techstile.drycleanservice.controller;

import in.ogmatech.techstile.drycleanservice.exception.AlreadyExistsException;
import in.ogmatech.techstile.drycleanservice.model.Customer;
import in.ogmatech.techstile.drycleanservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /* Create a customer */
    @PostMapping("customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer, UriComponentsBuilder ucBuilder) {

        if (customerService.isExist(customer)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        customerService.save(customer);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("customers/{id}").buildAndExpand(customer.getIdCustomer()).toUri());

        return new ResponseEntity<>(customer, headers, HttpStatus.CREATED);
    }

    /* Reading single customer */
    @GetMapping(value = "customers/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") long idCustomer) {

        Customer customer = customerService.findById(idCustomer);

        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    /*Reads all customers*/
    @GetMapping(value = "customers",produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<List<Customer>> listAllCustomers() {

        List<Customer> customer = customerService.findAll();

        if (customer.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    /*Update a customer*/
    @PutMapping("customers/{id}")
    public ResponseEntity<Customer> updateCustomerFromDB(@PathVariable("id") Long idCustomer, @RequestBody Customer customer) {

        Customer currentCustomer = customerService.findById(idCustomer);

        if (currentCustomer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        customerService.update(idCustomer, customer);

        Customer updatedCustomer = customerService.findById(idCustomer);

        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }

    /*Delete a customer */
    @DeleteMapping("customers/{id}")
    public ResponseEntity<Customer> deleteCustomerFromDB(@PathVariable("id") long idCustomer) {

        Customer customer = customerService.findById(idCustomer);

        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        customerService.delete(idCustomer);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*Delete all customers*/
    @DeleteMapping("customers")
    public ResponseEntity<Customer> deleteAllCustomers() {

        customerService.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleCustomerAlreadyExistsException(AlreadyExistsException exception) {

        return exception.getMessage();
    }
}
