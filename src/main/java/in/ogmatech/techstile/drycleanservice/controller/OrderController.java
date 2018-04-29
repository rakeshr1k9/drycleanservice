package in.ogmatech.techstile.drycleanservice.controller;

import in.ogmatech.techstile.drycleanservice.exception.AlreadyExistsException;
import in.ogmatech.techstile.drycleanservice.model.Order;
import in.ogmatech.techstile.drycleanservice.service.OrderService;
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
public class OrderController {

    @Autowired
    private OrderService orderService;

    /* Create a order */
    @PostMapping("orders")
    public ResponseEntity<Order> createOrder(@RequestBody Order order, UriComponentsBuilder ucBuilder) {

        if (orderService.isExist(order)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        orderService.save(order);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("orders/{id}").buildAndExpand(order.getIdOrder()).toUri());

        return new ResponseEntity<>(order, headers, HttpStatus.CREATED);
    }

    /* Reading single order */
    @GetMapping(value = "orders/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> getOrder(@PathVariable("id") long idOrder) {

        Order order = orderService.findById(idOrder);

        if (order == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    /*Reads all orders*/
    @GetMapping(value = "orders",produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<List<Order>> listAllOrders() {

        List<Order> order = orderService.findAll();

        if (order.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    /*Update a order*/
    @PutMapping("orders/{id}")
    public ResponseEntity<Order> updateOrderFromDB(@PathVariable("id") Long idOrder, @RequestBody Order order) {

        Order currentOrder = orderService.findById(idOrder);

        if (currentOrder == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        orderService.update(idOrder, order);

        Order updatedOrder = orderService.findById(idOrder);

        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
    }

    /*Delete a order */
    @DeleteMapping("orders/{id}")
    public ResponseEntity<Order> deleteOrderFromDB(@PathVariable("id") long idOrder) {

        Order order = orderService.findById(idOrder);

        if (order == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        orderService.delete(idOrder);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*Delete all orders*/
    @DeleteMapping("orders")
    public ResponseEntity<Order> deleteAllOrders() {

        orderService.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleOrderAlreadyExistsException(AlreadyExistsException exception) {

        return exception.getMessage();
    }
}
