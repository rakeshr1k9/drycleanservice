package in.ogmatech.techstile.drycleanservice.controller;

import in.ogmatech.techstile.drycleanservice.exception.AlreadyExistsException;
import in.ogmatech.techstile.drycleanservice.model.ItemCategory;
import in.ogmatech.techstile.drycleanservice.service.ItemCategoryService;
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
public class ItemCategoryController {

    @Autowired
    private ItemCategoryService itemCategoryService;

    /* Create a itemCategory */
    @PostMapping("itemCategories")
    public ResponseEntity<ItemCategory> createItemCategory(@RequestBody ItemCategory itemCategory, UriComponentsBuilder ucBuilder) {

        if (itemCategoryService.isExist(itemCategory)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        itemCategoryService.save(itemCategory);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("itemCategories/{id}").buildAndExpand(itemCategory.getIdItemCategory()).toUri());

        return new ResponseEntity<>(itemCategory, headers, HttpStatus.CREATED);
    }

    /* Reading single itemCategory */
    @GetMapping(value = "itemCategories/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ItemCategory> getItemCategory(@PathVariable("id") long idItemCategory) {

        ItemCategory itemCategory = itemCategoryService.findById(idItemCategory);

        if (itemCategory == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(itemCategory, HttpStatus.OK);
    }

    /*Reads all itemCategories*/
    @GetMapping(value = "itemCategories",produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<List<ItemCategory>> listAllItemCategories() {

        List<ItemCategory> itemCategory = itemCategoryService.findAll();

        if (itemCategory.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(itemCategory, HttpStatus.OK);
    }

    /*Update a itemCategory*/
    @PutMapping("itemCategories/{id}")
    public ResponseEntity<ItemCategory> updateItemCategoryFromDB(@PathVariable("id") Long idItemCategory, @RequestBody ItemCategory itemCategory) {

        ItemCategory currentItemCategory = itemCategoryService.findById(idItemCategory);

        if (currentItemCategory == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        itemCategoryService.update(idItemCategory, itemCategory);

        ItemCategory updatedItemCategory = itemCategoryService.findById(idItemCategory);

        return new ResponseEntity<>(updatedItemCategory, HttpStatus.OK);
    }

    /*Delete a itemCategory */
    @DeleteMapping("itemCategories/{id}")
    public ResponseEntity<ItemCategory> deleteItemCategoryFromDB(@PathVariable("id") long idItemCategory) {

        ItemCategory itemCategory = itemCategoryService.findById(idItemCategory);

        if (itemCategory == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        itemCategoryService.delete(idItemCategory);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*Delete all itemCategories*/
    @DeleteMapping("itemCategories")
    public ResponseEntity<ItemCategory> deleteAllItemCategories() {

        itemCategoryService.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleItemCategoryAlreadyExistsException(AlreadyExistsException exception) {

        return exception.getMessage();
    }
}
