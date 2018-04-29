package in.ogmatech.techstile.drycleanservice.controller;

import in.ogmatech.techstile.drycleanservice.exception.AlreadyExistsException;
import in.ogmatech.techstile.drycleanservice.model.ItemStatus;
import in.ogmatech.techstile.drycleanservice.service.ItemStatusService;
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
public class ItemStatusController {

    @Autowired
    private ItemStatusService itemStatusService;

    /* Create a itemStatus */
    @PostMapping("itemStatuses")
    public ResponseEntity<ItemStatus> createItemStatus(@RequestBody ItemStatus itemStatus, UriComponentsBuilder ucBuilder) {

        if (itemStatusService.isExist(itemStatus)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        itemStatusService.save(itemStatus);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("itemStatuses/{id}").buildAndExpand(itemStatus.getIdItemStatus()).toUri());

        return new ResponseEntity<>(itemStatus, headers, HttpStatus.CREATED);
    }

    /* Reading single itemStatus */
    @GetMapping(value = "itemStatuses/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ItemStatus> getItemStatus(@PathVariable("id") long idItemStatus) {

        ItemStatus itemStatus = itemStatusService.findById(idItemStatus);

        if (itemStatus == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(itemStatus, HttpStatus.OK);
    }

    /*Reads all itemStatuses*/
    @GetMapping(value = "itemStatuses",produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<List<ItemStatus>> listAllItemStatuses() {

        List<ItemStatus> itemStatus = itemStatusService.findAll();

        if (itemStatus.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(itemStatus, HttpStatus.OK);
    }

    /*Update a itemStatus*/
    @PutMapping("itemStatuses/{id}")
    public ResponseEntity<ItemStatus> updateItemStatusFromDB(@PathVariable("id") Long idItemStatus, @RequestBody ItemStatus itemStatus) {

        ItemStatus currentItemStatus = itemStatusService.findById(idItemStatus);

        if (currentItemStatus == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        itemStatusService.update(idItemStatus, itemStatus);

        ItemStatus updatedItemStatus = itemStatusService.findById(idItemStatus);

        return new ResponseEntity<>(updatedItemStatus, HttpStatus.OK);
    }

    /*Delete a itemStatus */
    @DeleteMapping("itemStatuses/{id}")
    public ResponseEntity<ItemStatus> deleteItemStatusFromDB(@PathVariable("id") long idItemStatus) {

        ItemStatus itemStatus = itemStatusService.findById(idItemStatus);

        if (itemStatus == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        itemStatusService.delete(idItemStatus);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*Delete all itemStatuses*/
    @DeleteMapping("itemStatuses")
    public ResponseEntity<ItemStatus> deleteAllItemStatuses() {

        itemStatusService.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleItemStatusAlreadyExistsException(AlreadyExistsException exception) {

        return exception.getMessage();
    }
}
