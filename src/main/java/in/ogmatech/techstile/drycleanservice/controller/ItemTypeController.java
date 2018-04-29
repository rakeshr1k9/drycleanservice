package in.ogmatech.techstile.drycleanservice.controller;

import in.ogmatech.techstile.drycleanservice.exception.AlreadyExistsException;
import in.ogmatech.techstile.drycleanservice.model.ItemType;
import in.ogmatech.techstile.drycleanservice.service.ItemTypeService;
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
public class ItemTypeController {

    @Autowired
    private ItemTypeService itemTypeService;

    /* Create a itemType */
    @PostMapping("itemTypes")
    public ResponseEntity<ItemType> createItemType(@RequestBody ItemType itemType, UriComponentsBuilder ucBuilder) {

        if (itemTypeService.isExist(itemType)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        itemTypeService.save(itemType);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("itemTypes/{id}").buildAndExpand(itemType.getIdItemType()).toUri());

        return new ResponseEntity<>(itemType, headers, HttpStatus.CREATED);
    }

    /* Reading single itemType */
    @GetMapping(value = "itemTypes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ItemType> getItemType(@PathVariable("id") long idItemType) {

        ItemType itemType = itemTypeService.findById(idItemType);

        if (itemType == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(itemType, HttpStatus.OK);
    }

    /*Reads all itemTypes*/
    @GetMapping(value = "itemTypes",produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<List<ItemType>> listAllItemTypes() {

        List<ItemType> itemType = itemTypeService.findAll();

        if (itemType.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(itemType, HttpStatus.OK);
    }

    /*Update a itemType*/
    @PutMapping("itemTypes/{id}")
    public ResponseEntity<ItemType> updateItemTypeFromDB(@PathVariable("id") Long idItemType, @RequestBody ItemType itemType) {

        ItemType currentItemType = itemTypeService.findById(idItemType);

        if (currentItemType == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        itemTypeService.update(idItemType, itemType);

        ItemType updatedItemType = itemTypeService.findById(idItemType);

        return new ResponseEntity<>(updatedItemType, HttpStatus.OK);
    }

    /*Delete a itemType */
    @DeleteMapping("itemTypes/{id}")
    public ResponseEntity<ItemType> deleteItemTypeFromDB(@PathVariable("id") long idItemType) {

        ItemType itemType = itemTypeService.findById(idItemType);

        if (itemType == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        itemTypeService.delete(idItemType);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*Delete all itemTypes*/
    @DeleteMapping("itemTypes")
    public ResponseEntity<ItemType> deleteAllItemTypes() {

        itemTypeService.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleItemTypeAlreadyExistsException(AlreadyExistsException exception) {

        return exception.getMessage();
    }
}
