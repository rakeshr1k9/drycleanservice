package in.ogmatech.techstile.drycleanservice.controller;

import in.ogmatech.techstile.drycleanservice.exception.AlreadyExistsException;
import in.ogmatech.techstile.drycleanservice.model.PaymentType;
import in.ogmatech.techstile.drycleanservice.service.PaymentTypeService;
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
public class PaymentTypeController {

    @Autowired
    private PaymentTypeService paymentTypeService;

    /* Create a paymentType */
    @PostMapping("paymentTypes")
    public ResponseEntity<PaymentType> createPaymentType(@RequestBody PaymentType paymentType, UriComponentsBuilder ucBuilder) {

        if (paymentTypeService.isExist(paymentType)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        paymentTypeService.save(paymentType);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("paymentTypes/{id}").buildAndExpand(paymentType.getIdPaymentType()).toUri());

        return new ResponseEntity<>(paymentType, headers, HttpStatus.CREATED);
    }

    /* Reading single paymentType */
    @GetMapping(value = "paymentTypes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PaymentType> getPaymentType(@PathVariable("id") long idPaymentType) {

        PaymentType paymentType = paymentTypeService.findById(idPaymentType);

        if (paymentType == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(paymentType, HttpStatus.OK);
    }

    /*Reads all paymentTypes*/
    @GetMapping(value = "paymentTypes",produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<List<PaymentType>> listAllPaymentTypes() {

        List<PaymentType> paymentType = paymentTypeService.findAll();

        if (paymentType.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(paymentType, HttpStatus.OK);
    }

    /*Update a paymentType*/
    @PutMapping("paymentTypes/{id}")
    public ResponseEntity<PaymentType> updatePaymentTypeFromDB(@PathVariable("id") Long idPaymentType, @RequestBody PaymentType paymentType) {

        PaymentType currentPaymentType = paymentTypeService.findById(idPaymentType);

        if (currentPaymentType == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        paymentTypeService.update(idPaymentType, paymentType);

        PaymentType updatedPaymentType = paymentTypeService.findById(idPaymentType);

        return new ResponseEntity<>(updatedPaymentType, HttpStatus.OK);
    }

    /*Delete a paymentType */
    @DeleteMapping("paymentTypes/{id}")
    public ResponseEntity<PaymentType> deletePaymentTypeFromDB(@PathVariable("id") long idPaymentType) {

        PaymentType paymentType = paymentTypeService.findById(idPaymentType);

        if (paymentType == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        paymentTypeService.delete(idPaymentType);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*Delete all paymentTypes*/
    @DeleteMapping("paymentTypes")
    public ResponseEntity<PaymentType> deleteAllPaymentTypes() {

        paymentTypeService.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handlePaymentTypeAlreadyExistsException(AlreadyExistsException exception) {

        return exception.getMessage();
    }
}
