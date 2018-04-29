package in.ogmatech.techstile.drycleanservice.controller;

import in.ogmatech.techstile.drycleanservice.exception.AlreadyExistsException;
import in.ogmatech.techstile.drycleanservice.model.Item;
import in.ogmatech.techstile.drycleanservice.service.ItemService;
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
public class ItemController {

    @Autowired
    private ItemService itemService;

    /* Create a item */
    @PostMapping("items")
    public ResponseEntity<Item> createItem(@RequestBody Item item, UriComponentsBuilder ucBuilder) {

        if (itemService.isExist(item)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        itemService.save(item);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("items/{id}").buildAndExpand(item.getIdItem()).toUri());

        return new ResponseEntity<>(item, headers, HttpStatus.CREATED);
    }

    /* Reading single item */
    @GetMapping(value = "items/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> getItem(@PathVariable("id") long idItem) {

        Item item = itemService.findById(idItem);

        if (item == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    /*Reads all items*/
    @GetMapping(value = "items",produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<List<Item>> listAllItems() {

        List<Item> item = itemService.findAll();

        if (item.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    /*Update a item*/
    @PutMapping("items/{id}")
    public ResponseEntity<Item> updateItemFromDB(@PathVariable("id") Long idItem, @RequestBody Item item) {

        Item currentItem = itemService.findById(idItem);

        if (currentItem == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        itemService.update(idItem, item);

        Item updatedItem = itemService.findById(idItem);

        return new ResponseEntity<>(updatedItem, HttpStatus.OK);
    }

    /*Delete a item */
    @DeleteMapping("items/{id}")
    public ResponseEntity<Item> deleteItemFromDB(@PathVariable("id") long idItem) {

        Item item = itemService.findById(idItem);

        if (item == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        itemService.delete(idItem);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*Delete all items*/
    @DeleteMapping("items")
    public ResponseEntity<Item> deleteAllItems() {

        itemService.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleItemAlreadyExistsException(AlreadyExistsException exception) {

        return exception.getMessage();
    }
}
