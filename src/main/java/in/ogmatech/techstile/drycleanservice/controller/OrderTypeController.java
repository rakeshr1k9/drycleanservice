package in.ogmatech.techstile.drycleanservice.controller;

import in.ogmatech.techstile.drycleanservice.exception.AlreadyExistsException;
import in.ogmatech.techstile.drycleanservice.model.OrderType;
import in.ogmatech.techstile.drycleanservice.service.OrderTypeService;
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
public class OrderTypeController {

    @Autowired
    private OrderTypeService orderTypeService;

    /* Create a orderType */
    @PostMapping("orderTypes")
    public ResponseEntity<OrderType> createOrderType(@RequestBody OrderType orderType, UriComponentsBuilder ucBuilder) {

        if (orderTypeService.isExist(orderType)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        orderTypeService.save(orderType);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("orderTypes/{id}").buildAndExpand(orderType.getIdOrderType()).toUri());

        return new ResponseEntity<>(orderType, headers, HttpStatus.CREATED);
    }

    /* Reading single orderType */
    @GetMapping(value = "orderTypes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderType> getOrderType(@PathVariable("id") long idOrderType) {

        OrderType orderType = orderTypeService.findById(idOrderType);

        if (orderType == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(orderType, HttpStatus.OK);
    }

    /*Reads all orderTypes*/
    @GetMapping(value = "orderTypes",produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<List<OrderType>> listAllOrderTypes() {

        List<OrderType> orderType = orderTypeService.findAll();

        if (orderType.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(orderType, HttpStatus.OK);
    }

    /*Update a orderType*/
    @PutMapping("orderTypes/{id}")
    public ResponseEntity<OrderType> updateOrderTypeFromDB(@PathVariable("id") Long idOrderType, @RequestBody OrderType orderType) {

        OrderType currentOrderType = orderTypeService.findById(idOrderType);

        if (currentOrderType == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        orderTypeService.update(idOrderType, orderType);

        OrderType updatedOrderType = orderTypeService.findById(idOrderType);

        return new ResponseEntity<>(updatedOrderType, HttpStatus.OK);
    }

    /*Delete a orderType */
    @DeleteMapping("orderTypes/{id}")
    public ResponseEntity<OrderType> deleteOrderTypeFromDB(@PathVariable("id") long idOrderType) {

        OrderType orderType = orderTypeService.findById(idOrderType);

        if (orderType == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        orderTypeService.delete(idOrderType);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*Delete all orderTypes*/
    @DeleteMapping("orderTypes")
    public ResponseEntity<OrderType> deleteAllOrderTypes() {

        orderTypeService.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleOrderTypeAlreadyExistsException(AlreadyExistsException exception) {

        return exception.getMessage();
    }
}
