package in.ogmatech.techstile.drycleanservice.controller;

import in.ogmatech.techstile.drycleanservice.exception.AlreadyExistsException;
import in.ogmatech.techstile.drycleanservice.model.ServiceTypeSplit;
import in.ogmatech.techstile.drycleanservice.service.ServiceTypeSplitService;
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
public class ServiceTypeSplitController {

    @Autowired
    private ServiceTypeSplitService serviceTypeSplitService;

    /* Create a serviceTypeSplit */
    @PostMapping("serviceTypeSplits")
    public ResponseEntity<ServiceTypeSplit> createServiceTypeSplit(@RequestBody ServiceTypeSplit serviceTypeSplit, UriComponentsBuilder ucBuilder) {

        if (serviceTypeSplitService.isExist(serviceTypeSplit)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        serviceTypeSplitService.save(serviceTypeSplit);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("serviceTypeSplits/{id}").buildAndExpand(serviceTypeSplit.getIdServiceTypeSplit()).toUri());

        return new ResponseEntity<>(serviceTypeSplit, headers, HttpStatus.CREATED);
    }

    /* Reading single serviceTypeSplit */
    @GetMapping(value = "serviceTypeSplits/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceTypeSplit> getServiceTypeSplit(@PathVariable("id") long idServiceTypeSplit) {

        ServiceTypeSplit serviceTypeSplit = serviceTypeSplitService.findById(idServiceTypeSplit);

        if (serviceTypeSplit == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(serviceTypeSplit, HttpStatus.OK);
    }

    /*Reads all serviceTypeSplits*/
    @GetMapping(value = "serviceTypeSplits",produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<List<ServiceTypeSplit>> listAllServiceTypeSplits() {

        List<ServiceTypeSplit> serviceTypeSplit = serviceTypeSplitService.findAll();

        if (serviceTypeSplit.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(serviceTypeSplit, HttpStatus.OK);
    }

    /*Update a serviceTypeSplit*/
    @PutMapping("serviceTypeSplits/{id}")
    public ResponseEntity<ServiceTypeSplit> updateServiceTypeSplitFromDB(@PathVariable("id") Long idServiceTypeSplit, @RequestBody ServiceTypeSplit serviceTypeSplit) {

        ServiceTypeSplit currentServiceTypeSplit = serviceTypeSplitService.findById(idServiceTypeSplit);

        if (currentServiceTypeSplit == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        serviceTypeSplitService.update(idServiceTypeSplit, serviceTypeSplit);

        ServiceTypeSplit updatedServiceTypeSplit = serviceTypeSplitService.findById(idServiceTypeSplit);

        return new ResponseEntity<>(updatedServiceTypeSplit, HttpStatus.OK);
    }

    /*Delete a serviceTypeSplit */
    @DeleteMapping("serviceTypeSplits/{id}")
    public ResponseEntity<ServiceTypeSplit> deleteServiceTypeSplitFromDB(@PathVariable("id") long idServiceTypeSplit) {

        ServiceTypeSplit serviceTypeSplit = serviceTypeSplitService.findById(idServiceTypeSplit);

        if (serviceTypeSplit == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        serviceTypeSplitService.delete(idServiceTypeSplit);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*Delete all serviceTypeSplits*/
    @DeleteMapping("serviceTypeSplits")
    public ResponseEntity<ServiceTypeSplit> deleteAllServiceTypeSplits() {

        serviceTypeSplitService.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleServiceTypeSplitAlreadyExistsException(AlreadyExistsException exception) {

        return exception.getMessage();
    }
}
