package in.ogmatech.techstile.drycleanservice.controller;

import in.ogmatech.techstile.drycleanservice.exception.AlreadyExistsException;
import in.ogmatech.techstile.drycleanservice.model.ServiceN;
import in.ogmatech.techstile.drycleanservice.service.ServiceService;
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
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    /* Create a service */
    @PostMapping("services")
    public ResponseEntity<ServiceN> createService(@RequestBody ServiceN service, UriComponentsBuilder ucBuilder) {

        if (serviceService.isExist(service)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        serviceService.save(service);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("services/{id}").buildAndExpand(service.getIdService()).toUri());

        return new ResponseEntity<>(service, headers, HttpStatus.CREATED);
    }

    /* Reading single service */
    @GetMapping(value = "services/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceN> getService(@PathVariable("id") long idService) {

        ServiceN service = serviceService.findById(idService);

        if (service == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(service, HttpStatus.OK);
    }

    /*Reads all services*/
    @GetMapping(value = "services",produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<List<ServiceN>> listAllServices() {

        List<ServiceN> service = serviceService.findAll();

        if (service.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(service, HttpStatus.OK);
    }

    /*Update a service*/
    @PutMapping("services/{id}")
    public ResponseEntity<ServiceN> updateServiceFromDB(@PathVariable("id") Long idService, @RequestBody ServiceN service) {

        ServiceN currentService = serviceService.findById(idService);

        if (currentService == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        serviceService.update(idService, service);

        ServiceN updatedService = serviceService.findById(idService);

        return new ResponseEntity<>(updatedService, HttpStatus.OK);
    }

    /*Delete a service */
    @DeleteMapping("services/{id}")
    public ResponseEntity<ServiceN> deleteServiceFromDB(@PathVariable("id") long idService) {

        ServiceN service = serviceService.findById(idService);

        if (service == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        serviceService.delete(idService);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*Delete all services*/
    @DeleteMapping("services")
    public ResponseEntity<ServiceN> deleteAllServices() {

        serviceService.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleServiceAlreadyExistsException(AlreadyExistsException exception) {

        return exception.getMessage();
    }
}
