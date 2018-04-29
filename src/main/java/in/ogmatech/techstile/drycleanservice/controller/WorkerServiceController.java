package in.ogmatech.techstile.drycleanservice.controller;

import in.ogmatech.techstile.drycleanservice.exception.AlreadyExistsException;
import in.ogmatech.techstile.drycleanservice.model.WorkerService;
import in.ogmatech.techstile.drycleanservice.service.WorkerServiceService;
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
public class WorkerServiceController {

    @Autowired
    private WorkerServiceService workerServiceService;

    /* Create a workerService */
    @PostMapping("workerServices")
    public ResponseEntity<WorkerService> createWorkerService(@RequestBody WorkerService workerService, UriComponentsBuilder ucBuilder) {

        if (workerServiceService.isExist(workerService)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        workerServiceService.save(workerService);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("workerServices/{id}").buildAndExpand(workerService.getIdWorkerService()).toUri());

        return new ResponseEntity<>(workerService, headers, HttpStatus.CREATED);
    }

    /* Reading single workerService */
    @GetMapping(value = "workerServices/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WorkerService> getWorkerService(@PathVariable("id") long idWorkerService) {

        WorkerService workerService = workerServiceService.findById(idWorkerService);

        if (workerService == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(workerService, HttpStatus.OK);
    }

    /*Reads all workerServices*/
    @GetMapping(value = "workerServices",produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<List<WorkerService>> listAllWorkerServices() {

        List<WorkerService> workerService = workerServiceService.findAll();

        if (workerService.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(workerService, HttpStatus.OK);
    }

    /*Update a workerService*/
    @PutMapping("workerServices/{id}")
    public ResponseEntity<WorkerService> updateWorkerServiceFromDB(@PathVariable("id") Long idWorkerService, @RequestBody WorkerService workerService) {

        WorkerService currentWorkerService = workerServiceService.findById(idWorkerService);

        if (currentWorkerService == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        workerServiceService.update(idWorkerService, workerService);

        WorkerService updatedWorkerService = workerServiceService.findById(idWorkerService);

        return new ResponseEntity<>(updatedWorkerService, HttpStatus.OK);
    }

    /*Delete a workerService */
    @DeleteMapping("workerServices/{id}")
    public ResponseEntity<WorkerService> deleteWorkerServiceFromDB(@PathVariable("id") long idWorkerService) {

        WorkerService workerService = workerServiceService.findById(idWorkerService);

        if (workerService == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        workerServiceService.delete(idWorkerService);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*Delete all workerServices*/
    @DeleteMapping("workerServices")
    public ResponseEntity<WorkerService> deleteAllWorkerServices() {

        workerServiceService.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleWorkerServiceAlreadyExistsException(AlreadyExistsException exception) {

        return exception.getMessage();
    }
}
