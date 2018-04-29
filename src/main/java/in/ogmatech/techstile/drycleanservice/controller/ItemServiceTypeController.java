package in.ogmatech.techstile.drycleanservice.controller;

import in.ogmatech.techstile.drycleanservice.exception.AlreadyExistsException;
import in.ogmatech.techstile.drycleanservice.model.ItemServiceType;
import in.ogmatech.techstile.drycleanservice.service.ItemServiceTypeService;
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
public class ItemServiceTypeController {

    @Autowired
    private ItemServiceTypeService itemServiceTypeService;

    /* Create a itemServiceType */
    @PostMapping("itemServiceTypes")
    public ResponseEntity<ItemServiceType> createItemServiceType(@RequestBody ItemServiceType itemServiceType, UriComponentsBuilder ucBuilder) {

        if (itemServiceTypeService.isExist(itemServiceType)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        itemServiceTypeService.save(itemServiceType);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("itemServiceTypes/{id}").buildAndExpand(itemServiceType.getIdItemServiceType()).toUri());

        return new ResponseEntity<>(itemServiceType, headers, HttpStatus.CREATED);
    }

    /* Reading single itemServiceType */
    @GetMapping(value = "itemServiceTypes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ItemServiceType> getItemServiceType(@PathVariable("id") long idItemServiceType) {

        ItemServiceType itemServiceType = itemServiceTypeService.findById(idItemServiceType);

        if (itemServiceType == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(itemServiceType, HttpStatus.OK);
    }

    /*Reads all itemServiceTypes*/
    @GetMapping(value = "itemServiceTypes",produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<List<ItemServiceType>> listAllItemServiceTypes() {

        List<ItemServiceType> itemServiceType = itemServiceTypeService.findAll();

        if (itemServiceType.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(itemServiceType, HttpStatus.OK);
    }

    /*Update a itemServiceType*/
    @PutMapping("itemServiceTypes/{id}")
    public ResponseEntity<ItemServiceType> updateItemServiceTypeFromDB(@PathVariable("id") Long idItemServiceType, @RequestBody ItemServiceType itemServiceType) {

        ItemServiceType currentItemServiceType = itemServiceTypeService.findById(idItemServiceType);

        if (currentItemServiceType == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        itemServiceTypeService.update(idItemServiceType, itemServiceType);

        ItemServiceType updatedItemServiceType = itemServiceTypeService.findById(idItemServiceType);

        return new ResponseEntity<>(updatedItemServiceType, HttpStatus.OK);
    }

    /*Delete a itemServiceType */
    @DeleteMapping("itemServiceTypes/{id}")
    public ResponseEntity<ItemServiceType> deleteItemServiceTypeFromDB(@PathVariable("id") long idItemServiceType) {

        ItemServiceType itemServiceType = itemServiceTypeService.findById(idItemServiceType);

        if (itemServiceType == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        itemServiceTypeService.delete(idItemServiceType);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*Delete all itemServiceTypes*/
    @DeleteMapping("itemServiceTypes")
    public ResponseEntity<ItemServiceType> deleteAllItemServiceTypes() {

        itemServiceTypeService.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleItemServiceTypeAlreadyExistsException(AlreadyExistsException exception) {

        return exception.getMessage();
    }
}
