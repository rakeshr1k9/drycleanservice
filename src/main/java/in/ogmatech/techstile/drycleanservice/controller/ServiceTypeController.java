package in.ogmatech.techstile.drycleanservice.controller;

import in.ogmatech.techstile.drycleanservice.exception.AlreadyExistsException;
import in.ogmatech.techstile.drycleanservice.model.ServiceType;
import in.ogmatech.techstile.drycleanservice.service.ServiceTypeService;
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
public class ServiceTypeController {

    @Autowired
    private ServiceTypeService serviceTypeService;

    /* Create a serviceType */
    @PostMapping("serviceTypes")
    public ResponseEntity<ServiceType> createServiceType(@RequestBody ServiceType serviceType, UriComponentsBuilder ucBuilder) {

        if (serviceTypeService.isExist(serviceType)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        serviceTypeService.save(serviceType);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("serviceTypes/{id}").buildAndExpand(serviceType.getIdServiceType()).toUri());

        return new ResponseEntity<>(serviceType, headers, HttpStatus.CREATED);
    }

    /* Reading single serviceType */
    @GetMapping(value = "serviceTypes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceType> getServiceType(@PathVariable("id") long idServiceType) {

        ServiceType serviceType = serviceTypeService.findById(idServiceType);

        if (serviceType == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(serviceType, HttpStatus.OK);
    }

    /*Reads all serviceTypes*/
    @GetMapping(value = "serviceTypes",produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<List<ServiceType>> listAllServiceTypes() {

        List<ServiceType> serviceType = serviceTypeService.findAll();

        if (serviceType.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(serviceType, HttpStatus.OK);
    }

    /*Update a serviceType*/
    @PutMapping("serviceTypes/{id}")
    public ResponseEntity<ServiceType> updateServiceTypeFromDB(@PathVariable("id") Long idServiceType, @RequestBody ServiceType serviceType) {

        ServiceType currentServiceType = serviceTypeService.findById(idServiceType);

        if (currentServiceType == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        serviceTypeService.update(idServiceType, serviceType);

        ServiceType updatedServiceType = serviceTypeService.findById(idServiceType);

        return new ResponseEntity<>(updatedServiceType, HttpStatus.OK);
    }

    /*Delete a serviceType */
    @DeleteMapping("serviceTypes/{id}")
    public ResponseEntity<ServiceType> deleteServiceTypeFromDB(@PathVariable("id") long idServiceType) {

        ServiceType serviceType = serviceTypeService.findById(idServiceType);

        if (serviceType == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        serviceTypeService.delete(idServiceType);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*Delete all serviceTypes*/
    @DeleteMapping("serviceTypes")
    public ResponseEntity<ServiceType> deleteAllServiceTypes() {

        serviceTypeService.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleServiceTypeAlreadyExistsException(AlreadyExistsException exception) {

        return exception.getMessage();
    }
}
