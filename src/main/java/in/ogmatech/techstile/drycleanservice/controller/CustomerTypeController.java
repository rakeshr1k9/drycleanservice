package in.ogmatech.techstile.drycleanservice.controller;

import in.ogmatech.techstile.drycleanservice.exception.AlreadyExistsException;
import in.ogmatech.techstile.drycleanservice.model.CustomerType;
import in.ogmatech.techstile.drycleanservice.service.CustomerTypeService;
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
public class CustomerTypeController {

    @Autowired
    private CustomerTypeService customerTypeService;

    /* Create a customerType */
    @PostMapping("customerTypes")
    public ResponseEntity<CustomerType> createCustomerType(@RequestBody CustomerType customerType, UriComponentsBuilder ucBuilder) {

        if (customerTypeService.isExist(customerType)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        customerTypeService.save(customerType);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("customerTypes/{id}").buildAndExpand(customerType.getIdCustomerType()).toUri());

        return new ResponseEntity<>(customerType, headers, HttpStatus.CREATED);
    }

    /* Reading single customerType */
    @GetMapping(value = "customerTypes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerType> getCustomerType(@PathVariable("id") long idCustomerType) {

        CustomerType customerType = customerTypeService.findById(idCustomerType);

        if (customerType == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(customerType, HttpStatus.OK);
    }

    /*Reads all customerTypes*/
    @GetMapping(value = "customerTypes",produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<List<CustomerType>> listAllCustomerTypes() {

        List<CustomerType> customerType = customerTypeService.findAll();

        if (customerType.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(customerType, HttpStatus.OK);
    }

    /*Update a customerType*/
    @PutMapping("customerTypes/{id}")
    public ResponseEntity<CustomerType> updateCustomerTypeFromDB(@PathVariable("id") Long idCustomerType, @RequestBody CustomerType customerType) {

        CustomerType currentCustomerType = customerTypeService.findById(idCustomerType);

        if (currentCustomerType == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        customerTypeService.update(idCustomerType, customerType);

        CustomerType updatedCustomerType = customerTypeService.findById(idCustomerType);

        return new ResponseEntity<>(updatedCustomerType, HttpStatus.OK);
    }

    /*Delete a customerType */
    @DeleteMapping("customerTypes/{id}")
    public ResponseEntity<CustomerType> deleteCustomerTypeFromDB(@PathVariable("id") long idCustomerType) {

        CustomerType customerType = customerTypeService.findById(idCustomerType);

        if (customerType == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        customerTypeService.delete(idCustomerType);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*Delete all customerTypes*/
    @DeleteMapping("customerTypes")
    public ResponseEntity<CustomerType> deleteAllCustomerTypes() {

        customerTypeService.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleCustomerTypeAlreadyExistsException(AlreadyExistsException exception) {

        return exception.getMessage();
    }
}
