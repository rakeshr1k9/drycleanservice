package in.ogmatech.techstile.drycleanservice.controller;

import in.ogmatech.techstile.drycleanservice.exception.AlreadyExistsException;
import in.ogmatech.techstile.drycleanservice.model.Payment;
import in.ogmatech.techstile.drycleanservice.service.PaymentService;
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
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    /* Create a payment */
    @PostMapping("payments")
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment, UriComponentsBuilder ucBuilder) {

        if (paymentService.isExist(payment)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        paymentService.save(payment);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("payments/{id}").buildAndExpand(payment.getIdPayment()).toUri());

        return new ResponseEntity<>(payment, headers, HttpStatus.CREATED);
    }

    /* Reading single payment */
    @GetMapping(value = "payments/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Payment> getPayment(@PathVariable("id") long idPayment) {

        Payment payment = paymentService.findById(idPayment);

        if (payment == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

    /*Reads all payments*/
    @GetMapping(value = "payments",produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<List<Payment>> listAllPayments() {

        List<Payment> payment = paymentService.findAll();

        if (payment.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

    /*Update a payment*/
    @PutMapping("payments/{id}")
    public ResponseEntity<Payment> updatePaymentFromDB(@PathVariable("id") Long idPayment, @RequestBody Payment payment) {

        Payment currentPayment = paymentService.findById(idPayment);

        if (currentPayment == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        paymentService.update(idPayment, payment);

        Payment updatedPayment = paymentService.findById(idPayment);

        return new ResponseEntity<>(updatedPayment, HttpStatus.OK);
    }

    /*Delete a payment */
    @DeleteMapping("payments/{id}")
    public ResponseEntity<Payment> deletePaymentFromDB(@PathVariable("id") long idPayment) {

        Payment payment = paymentService.findById(idPayment);

        if (payment == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        paymentService.delete(idPayment);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*Delete all payments*/
    @DeleteMapping("payments")
    public ResponseEntity<Payment> deleteAllPayments() {

        paymentService.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handlePaymentAlreadyExistsException(AlreadyExistsException exception) {

        return exception.getMessage();
    }
}
