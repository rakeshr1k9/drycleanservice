package in.ogmatech.techstile.drycleanservice.controller;

import in.ogmatech.techstile.drycleanservice.exception.AlreadyExistsException;
import in.ogmatech.techstile.drycleanservice.model.Remark;
import in.ogmatech.techstile.drycleanservice.service.RemarkService;
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
public class RemarkController {

    @Autowired
    private RemarkService remarkService;

    /* Create a remark */
    @PostMapping("remarks")
    public ResponseEntity<Remark> createRemark(@RequestBody Remark remark, UriComponentsBuilder ucBuilder) {

        if (remarkService.isExist(remark)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        remarkService.save(remark);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("remarks/{id}").buildAndExpand(remark.getIdRemark()).toUri());

        return new ResponseEntity<>(remark, headers, HttpStatus.CREATED);
    }

    /* Reading single remark */
    @GetMapping(value = "remarks/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Remark> getRemark(@PathVariable("id") long idRemark) {

        Remark remark = remarkService.findById(idRemark);

        if (remark == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(remark, HttpStatus.OK);
    }

    /*Reads all remarks*/
    @GetMapping(value = "remarks",produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<List<Remark>> listAllRemarks() {

        List<Remark> remark = remarkService.findAll();

        if (remark.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(remark, HttpStatus.OK);
    }

    /*Update a remark*/
    @PutMapping("remarks/{id}")
    public ResponseEntity<Remark> updateRemarkFromDB(@PathVariable("id") Long idRemark, @RequestBody Remark remark) {

        Remark currentRemark = remarkService.findById(idRemark);

        if (currentRemark == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        remarkService.update(idRemark, remark);

        Remark updatedRemark = remarkService.findById(idRemark);

        return new ResponseEntity<>(updatedRemark, HttpStatus.OK);
    }

    /*Delete a remark */
    @DeleteMapping("remarks/{id}")
    public ResponseEntity<Remark> deleteRemarkFromDB(@PathVariable("id") long idRemark) {

        Remark remark = remarkService.findById(idRemark);

        if (remark == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        remarkService.delete(idRemark);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*Delete all remarks*/
    @DeleteMapping("remarks")
    public ResponseEntity<Remark> deleteAllRemarks() {

        remarkService.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleRemarkAlreadyExistsException(AlreadyExistsException exception) {

        return exception.getMessage();
    }
}
