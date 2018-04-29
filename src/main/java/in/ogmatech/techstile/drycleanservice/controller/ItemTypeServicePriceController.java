package in.ogmatech.techstile.drycleanservice.controller;

import in.ogmatech.techstile.drycleanservice.exception.AlreadyExistsException;
import in.ogmatech.techstile.drycleanservice.model.ItemTypeServicePrice;
import in.ogmatech.techstile.drycleanservice.service.ItemTypeServicePriceService;
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
public class ItemTypeServicePriceController {

    @Autowired
    private ItemTypeServicePriceService itemTypeServicePriceService;

    /* Create a itemTypeServicePrice */
    @PostMapping("itemTypeServicePrices")
    public ResponseEntity<ItemTypeServicePrice> createItemTypeServicePrice(@RequestBody ItemTypeServicePrice itemTypeServicePrice, UriComponentsBuilder ucBuilder) {

        if (itemTypeServicePriceService.isExist(itemTypeServicePrice)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        itemTypeServicePriceService.save(itemTypeServicePrice);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("itemTypeServicePrices/{id}").buildAndExpand(itemTypeServicePrice.getIdItemTypeServicePrice()).toUri());

        return new ResponseEntity<>(itemTypeServicePrice, headers, HttpStatus.CREATED);
    }

    /* Reading single itemTypeServicePrice */
    @GetMapping(value = "itemTypeServicePrices/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ItemTypeServicePrice> getItemTypeServicePrice(@PathVariable("id") long idItemTypeServicePrice) {

        ItemTypeServicePrice itemTypeServicePrice = itemTypeServicePriceService.findById(idItemTypeServicePrice);

        if (itemTypeServicePrice == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(itemTypeServicePrice, HttpStatus.OK);
    }

    /*Reads all itemTypeServicePrices*/
    @GetMapping(value = "itemTypeServicePrices",produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<List<ItemTypeServicePrice>> listAllItemTypeServicePrices() {

        List<ItemTypeServicePrice> itemTypeServicePrice = itemTypeServicePriceService.findAll();

        if (itemTypeServicePrice.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(itemTypeServicePrice, HttpStatus.OK);
    }

    /*Update a itemTypeServicePrice*/
    @PutMapping("itemTypeServicePrices/{id}")
    public ResponseEntity<ItemTypeServicePrice> updateItemTypeServicePriceFromDB(@PathVariable("id") Long idItemTypeServicePrice, @RequestBody ItemTypeServicePrice itemTypeServicePrice) {

        ItemTypeServicePrice currentItemTypeServicePrice = itemTypeServicePriceService.findById(idItemTypeServicePrice);

        if (currentItemTypeServicePrice == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        itemTypeServicePriceService.update(idItemTypeServicePrice, itemTypeServicePrice);

        ItemTypeServicePrice updatedItemTypeServicePrice = itemTypeServicePriceService.findById(idItemTypeServicePrice);

        return new ResponseEntity<>(updatedItemTypeServicePrice, HttpStatus.OK);
    }

    /*Delete a itemTypeServicePrice */
    @DeleteMapping("itemTypeServicePrices/{id}")
    public ResponseEntity<ItemTypeServicePrice> deleteItemTypeServicePriceFromDB(@PathVariable("id") long idItemTypeServicePrice) {

        ItemTypeServicePrice itemTypeServicePrice = itemTypeServicePriceService.findById(idItemTypeServicePrice);

        if (itemTypeServicePrice == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        itemTypeServicePriceService.delete(idItemTypeServicePrice);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*Delete all itemTypeServicePrices*/
    @DeleteMapping("itemTypeServicePrices")
    public ResponseEntity<ItemTypeServicePrice> deleteAllItemTypeServicePrices() {

        itemTypeServicePriceService.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleItemTypeServicePriceAlreadyExistsException(AlreadyExistsException exception) {

        return exception.getMessage();
    }
}
