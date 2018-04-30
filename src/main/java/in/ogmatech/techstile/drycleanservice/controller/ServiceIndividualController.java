package in.ogmatech.techstile.drycleanservice.controller;

import in.ogmatech.techstile.drycleanservice.exception.AlreadyExistsException;
import in.ogmatech.techstile.drycleanservice.model.ServiceIndividual;
import in.ogmatech.techstile.drycleanservice.service.ServiceIndividualService;
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
public class ServiceIndividualController {

    @Autowired
    private ServiceIndividualService serviceIndividualService;

    /* Create a serviceIndividual */
    @PostMapping("serviceIndividuals")
    public ResponseEntity<ServiceIndividual> createService(@RequestBody ServiceIndividual serviceIndividual, UriComponentsBuilder ucBuilder) {

        if (serviceIndividualService.isExist(serviceIndividual)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        serviceIndividualService.save(serviceIndividual);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("serviceIndividuals/{id}").buildAndExpand(serviceIndividual.getIdServiceIndividual()).toUri());

        return new ResponseEntity<>(serviceIndividual, headers, HttpStatus.CREATED);
    }

    /* Reading single serviceIndividual */
    @GetMapping(value = "serviceIndividuals/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceIndividual> getServiceIndividual(@PathVariable("id") long idServiceIndividual) {

        ServiceIndividual serviceIndividual = serviceIndividualService.findById(idServiceIndividual);

        if (serviceIndividual == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(serviceIndividual, HttpStatus.OK);
    }

    /*Reads all serviceIndividuals*/
    @GetMapping(value = "serviceIndividuals",produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<List<ServiceIndividual>> listAllServiceIndividuals() {

        List<ServiceIndividual> serviceIndividual = serviceIndividualService.findAll();

        if (serviceIndividual.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(serviceIndividual, HttpStatus.OK);
    }

    /*Update a serviceIndividual*/
    @PutMapping("serviceIndividuals/{id}")
    public ResponseEntity<ServiceIndividual> updateServiceFromDB(@PathVariable("id") Long idServiceIndividual, @RequestBody ServiceIndividual serviceIndividual) {

        ServiceIndividual currentServiceIndividual = serviceIndividualService.findById(idServiceIndividual);

        if (currentServiceIndividual == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        serviceIndividualService.update(idServiceIndividual, serviceIndividual);

        ServiceIndividual updatedServiceIndividual = serviceIndividualService.findById(idServiceIndividual);

        return new ResponseEntity<>(updatedServiceIndividual, HttpStatus.OK);
    }

    /*Delete a serviceIndividual */
    @DeleteMapping("serviceIndividuals/{id}")
    public ResponseEntity<ServiceIndividual> deleteServiceFromDB(@PathVariable("id") long idServiceIndividual) {

        ServiceIndividual serviceIndividual = serviceIndividualService.findById(idServiceIndividual);

        if (serviceIndividual == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        serviceIndividualService.delete(idServiceIndividual);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*Delete all serviceIndividuals*/
    @DeleteMapping("serviceIndividuals")
    public ResponseEntity<ServiceIndividual> deleteAllServiceIndividuals() {

        serviceIndividualService.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleServiceAlreadyExistsException(AlreadyExistsException exception) {

        return exception.getMessage();
    }
}
