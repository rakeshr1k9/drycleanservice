package in.ogmatech.techstile.drycleanservice.controller;

import in.ogmatech.techstile.drycleanservice.exception.AlreadyExistsException;
import in.ogmatech.techstile.drycleanservice.model.TempOrder;
import in.ogmatech.techstile.drycleanservice.service.TempOrderService;
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
public class TempOrderController {

    @Autowired
    private TempOrderService tempOrderService;

    /* Create a tempOrder */
    @PostMapping("tempOrders")
    public ResponseEntity<TempOrder> createTempOrder(@RequestBody TempOrder tempOrder, UriComponentsBuilder ucBuilder) {

        if (tempOrderService.isExist(tempOrder)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        tempOrderService.save(tempOrder);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("tempOrders/{id}").buildAndExpand(tempOrder.getIdTempOrder()).toUri());

        return new ResponseEntity<>(tempOrder, headers, HttpStatus.CREATED);
    }

    /* Reading single tempOrder */
    @GetMapping(value = "tempOrders/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TempOrder> getTempOrder(@PathVariable("id") long idTempOrder) {

        TempOrder tempOrder = tempOrderService.findById(idTempOrder);

        if (tempOrder == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(tempOrder, HttpStatus.OK);
    }

    /*Reads all tempOrders*/
    @GetMapping(value = "tempOrders",produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<List<TempOrder>> listAllTempOrders() {

        List<TempOrder> tempOrder = tempOrderService.findAll();

        if (tempOrder.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(tempOrder, HttpStatus.OK);
    }

    /*Update a tempOrder*/
    @PutMapping("tempOrders/{id}")
    public ResponseEntity<TempOrder> updateTempOrderFromDB(@PathVariable("id") Long idTempOrder, @RequestBody TempOrder tempOrder) {

        TempOrder currentTempOrder = tempOrderService.findById(idTempOrder);

        if (currentTempOrder == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        tempOrderService.update(idTempOrder, tempOrder);

        TempOrder updatedTempOrder = tempOrderService.findById(idTempOrder);

        return new ResponseEntity<>(updatedTempOrder, HttpStatus.OK);
    }

    /*Delete a tempOrder */
    @DeleteMapping("tempOrders/{id}")
    public ResponseEntity<TempOrder> deleteTempOrderFromDB(@PathVariable("id") long idTempOrder) {

        TempOrder tempOrder = tempOrderService.findById(idTempOrder);

        if (tempOrder == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        tempOrderService.delete(idTempOrder);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*Delete all tempOrders*/
    @DeleteMapping("tempOrders")
    public ResponseEntity<TempOrder> deleteAllTempOrders() {

        tempOrderService.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleTempOrderAlreadyExistsException(AlreadyExistsException exception) {

        return exception.getMessage();
    }
}
