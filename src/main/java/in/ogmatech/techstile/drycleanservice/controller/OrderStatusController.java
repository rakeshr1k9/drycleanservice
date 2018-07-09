package in.ogmatech.techstile.drycleanservice.controller;

import in.ogmatech.techstile.drycleanservice.exception.AlreadyExistsException;
import in.ogmatech.techstile.drycleanservice.model.OrderStatus;
import in.ogmatech.techstile.drycleanservice.service.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class OrderStatusController {

    @Autowired
    private OrderStatusService orderStatusService;

    /* Create a orderStatus */
    @PostMapping("orderStatuses")
    public ResponseEntity<OrderStatus> createOrderStatus(@RequestBody OrderStatus orderStatus, UriComponentsBuilder ucBuilder) {

        if (orderStatusService.isExist(orderStatus)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        orderStatusService.save(orderStatus);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("orderStatuses/{id}").buildAndExpand(orderStatus.getIdOrderStatus()).toUri());

        return new ResponseEntity<>(orderStatus, headers, HttpStatus.CREATED);
    }

    /* Reading single orderStatus */
    @GetMapping(value = "orderStatuses/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderStatus> getOrderStatus(@PathVariable("id") Integer idOrderStatus) {

        OrderStatus orderStatus = orderStatusService.findById(idOrderStatus);

        if (orderStatus == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(orderStatus, HttpStatus.OK);
    }

    /*Reads all orderStatuses*/
    @GetMapping(value = "orderStatuses",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OrderStatus>> listAllOrderStatuses() {

        List<OrderStatus> orderStatus = orderStatusService.findAll();

        if (orderStatus.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(orderStatus, HttpStatus.OK);
    }

    /*Update a orderStatus*/
    @PutMapping("orderStatuses/{id}")
    public ResponseEntity<OrderStatus> updateOrderStatusFromDB(@PathVariable("id") Integer idOrderStatus, @RequestBody OrderStatus orderStatus) {

        OrderStatus currentOrderStatus = orderStatusService.findById(idOrderStatus);

        if (currentOrderStatus == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        orderStatusService.update(idOrderStatus, orderStatus);

        OrderStatus updatedOrderStatus = orderStatusService.findById(idOrderStatus);

        return new ResponseEntity<>(updatedOrderStatus, HttpStatus.OK);
    }

    /*Delete a orderStatus */
    @DeleteMapping("orderStatuses/{id}")
    public ResponseEntity<OrderStatus> deleteOrderStatusFromDB(@PathVariable("id") Integer idOrderStatus) {

        OrderStatus orderStatus = orderStatusService.findById(idOrderStatus);

        if (orderStatus == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        orderStatusService.delete(idOrderStatus);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*Delete all orderStatuses*/
    @DeleteMapping("orderStatuses")
    public ResponseEntity<OrderStatus> deleteAllOrderStatuses() {

        orderStatusService.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleOrderStatusAlreadyExistsException(AlreadyExistsException exception) {

        return exception.getMessage();
    }
}
