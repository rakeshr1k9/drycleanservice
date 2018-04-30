package in.ogmatech.techstile.drycleanservice.controller;

import in.ogmatech.techstile.drycleanservice.exception.AlreadyExistsException;
import in.ogmatech.techstile.drycleanservice.model.ItemServiceScan;
import in.ogmatech.techstile.drycleanservice.service.ItemServiceScanService;
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
public class ItemServiceScanController {

    @Autowired
    private ItemServiceScanService itemServiceScanService;

    /* Create a itemServiceScan */
    @PostMapping("itemServiceScans")
    public ResponseEntity<ItemServiceScan> createItemServiceScan(@RequestBody ItemServiceScan itemServiceScan, UriComponentsBuilder ucBuilder) {

        if (itemServiceScanService.isExist(itemServiceScan)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        itemServiceScanService.save(itemServiceScan);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("itemServiceScans/{id}").buildAndExpand(itemServiceScan.getIdItemServiceScan()).toUri());

        return new ResponseEntity<>(itemServiceScan, headers, HttpStatus.CREATED);
    }

    /* Reading single itemServiceScan */
    @GetMapping(value = "itemServiceScans/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ItemServiceScan> getItemServiceScan(@PathVariable("id") long idItemServiceScan) {

        ItemServiceScan itemServiceScan = itemServiceScanService.findById(idItemServiceScan);

        if (itemServiceScan == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(itemServiceScan, HttpStatus.OK);
    }

    /*Reads all itemServiceScans*/
    @GetMapping(value = "itemServiceScans",produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<List<ItemServiceScan>> listAllItemServiceScans() {

        List<ItemServiceScan> itemServiceScan = itemServiceScanService.findAll();

        if (itemServiceScan.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(itemServiceScan, HttpStatus.OK);
    }

    /*Update a itemServiceScan*/
    @PutMapping("itemServiceScans/{id}")
    public ResponseEntity<ItemServiceScan> updateItemServiceScanFromDB(@PathVariable("id") Long idItemServiceScan, @RequestBody ItemServiceScan itemServiceScan) {

        ItemServiceScan currentItemServiceScan = itemServiceScanService.findById(idItemServiceScan);

        if (currentItemServiceScan == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        itemServiceScanService.update(idItemServiceScan, itemServiceScan);

        ItemServiceScan updatedItemServiceScan = itemServiceScanService.findById(idItemServiceScan);

        return new ResponseEntity<>(updatedItemServiceScan, HttpStatus.OK);
    }

    /*Delete a itemServiceScan */
    @DeleteMapping("itemServiceScans/{id}")
    public ResponseEntity<ItemServiceScan> deleteItemServiceScanFromDB(@PathVariable("id") long idItemServiceScan) {

        ItemServiceScan itemServiceScan = itemServiceScanService.findById(idItemServiceScan);

        if (itemServiceScan == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        itemServiceScanService.delete(idItemServiceScan);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*Delete all itemServiceScans*/
    @DeleteMapping("itemServiceScans")
    public ResponseEntity<ItemServiceScan> deleteAllItemServiceScans() {

        itemServiceScanService.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleItemServiceScanAlreadyExistsException(AlreadyExistsException exception) {

        return exception.getMessage();
    }
}
