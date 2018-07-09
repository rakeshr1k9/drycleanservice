package in.ogmatech.techstile.drycleanservice.controller;

import in.ogmatech.techstile.drycleanservice.exception.AlreadyExistsException;
import in.ogmatech.techstile.drycleanservice.model.*;
import in.ogmatech.techstile.drycleanservice.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;

@RestController
@RequestMapping("/api/")
public class OrderController {

    @Autowired
    private OrderService orderService;

    private Order order;

    /* Create a order */
    @PostMapping("order")
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
    @GetMapping(value = "order/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> getOrder(@PathVariable("id") Integer idOrder) {

        Order order = orderService.findById(idOrder);

        if (order == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    /*Reads all orders*/
    @GetMapping(value = "order", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Order>> getAllOrders() {

        List<Order> order = orderService.findAll();

        if (order.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    /*Reads active orders*/
    @GetMapping(value = "order/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Order>> listActiveOrders(
            @RequestParam(value = "branchId", required = true) Integer branchId,
            @RequestParam(value = "orderStatusId", required = true) List<Integer> orderStatusId) {

        Byte isDeleted = 0;
        List<Order> order = orderService.listAllOrders(isDeleted, branchId, orderStatusId);

        if (order.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    /*Reads quick*/
    @GetMapping(value = "order/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Order>> listSearchOrders(
            @RequestParam(value = "branchId", required = true) Integer branchId,
            @RequestParam(value = "searchOrder", required = true) String searchOrder) {

        Byte isDeleted = 0;
        Long customerMobile = Long.parseLong(searchOrder);
        Integer orderNumber = Integer.parseInt(searchOrder);

        List<Order> order;

        if(searchOrder.length() == 10){

            order = orderService.listOrdersByPhone(isDeleted, branchId, customerMobile);
        }
        else {
            order = orderService.listOrdersByOrderNo(isDeleted, branchId, orderNumber);
        }

        if (order.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    /*Reads quick*/
    @GetMapping(value = "order/quick", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Order>> listQuickOrders(
            @RequestParam(value = "branchId", required = true) Integer branchId,
            @RequestParam(value = "orderStatusId", required = true) List<Integer> orderStatusId) {

        Byte isDeleted = 0;
        Byte isQuickDelivery = 1;
        List<Order> order = orderService.listQuickOrders(isQuickDelivery, isDeleted, branchId, orderStatusId);

        if (order.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    /*Update a order*/
    @PutMapping("order/{id}")
    public ResponseEntity<Order> updateOrderFromDB(@PathVariable("id") Integer idOrder, @RequestBody Order order) {

        Order currentOrder = orderService.findById(idOrder);

        if (currentOrder == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        orderService.update(idOrder, order);

        Order updatedOrder = orderService.findById(idOrder);

        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
    }

    /*Delete a order */
    @DeleteMapping("order/{id}")
    public ResponseEntity<Order> deleteOrderFromDB(@PathVariable("id") Integer idOrder) {

        Order order = orderService.findById(idOrder);

        if (order == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        orderService.delete(idOrder);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*Delete all orders*/
    @DeleteMapping("order")
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
