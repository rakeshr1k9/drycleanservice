package in.ogmatech.techstile.drycleanservice.controller;

import in.ogmatech.techstile.drycleanservice.exception.AlreadyExistsException;
import in.ogmatech.techstile.drycleanservice.model.ItemRemark;
import in.ogmatech.techstile.drycleanservice.service.ItemRemarkService;
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
public class ItemRemarkController {

    @Autowired
    private ItemRemarkService itemRemarkService;

    /* Create a itemRemark */
    @PostMapping("itemRemarks")
    public ResponseEntity<ItemRemark> createItemRemark(@RequestBody ItemRemark itemRemark, UriComponentsBuilder ucBuilder) {

        if (itemRemarkService.isExist(itemRemark)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        itemRemarkService.save(itemRemark);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("itemRemarks/{id}").buildAndExpand(itemRemark.getIdItemRemark()).toUri());

        return new ResponseEntity<>(itemRemark, headers, HttpStatus.CREATED);
    }

    /* Reading single itemRemark */
    @GetMapping(value = "itemRemarks/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ItemRemark> getItemRemark(@PathVariable("id") long idItemRemark) {

        ItemRemark itemRemark = itemRemarkService.findById(idItemRemark);

        if (itemRemark == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(itemRemark, HttpStatus.OK);
    }

    /*Reads all itemRemarks*/
    @GetMapping(value = "itemRemarks",produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<List<ItemRemark>> listAllItemRemarks() {

        List<ItemRemark> itemRemark = itemRemarkService.findAll();

        if (itemRemark.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(itemRemark, HttpStatus.OK);
    }

    /*Update a itemRemark*/
    @PutMapping("itemRemarks/{id}")
    public ResponseEntity<ItemRemark> updateItemRemarkFromDB(@PathVariable("id") Long idItemRemark, @RequestBody ItemRemark itemRemark) {

        ItemRemark currentItemRemark = itemRemarkService.findById(idItemRemark);

        if (currentItemRemark == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        itemRemarkService.update(idItemRemark, itemRemark);

        ItemRemark updatedItemRemark = itemRemarkService.findById(idItemRemark);

        return new ResponseEntity<>(updatedItemRemark, HttpStatus.OK);
    }

    /*Delete a itemRemark */
    @DeleteMapping("itemRemarks/{id}")
    public ResponseEntity<ItemRemark> deleteItemRemarkFromDB(@PathVariable("id") long idItemRemark) {

        ItemRemark itemRemark = itemRemarkService.findById(idItemRemark);

        if (itemRemark == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        itemRemarkService.delete(idItemRemark);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*Delete all itemRemarks*/
    @DeleteMapping("itemRemarks")
    public ResponseEntity<ItemRemark> deleteAllItemRemarks() {

        itemRemarkService.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleItemRemarkAlreadyExistsException(AlreadyExistsException exception) {

        return exception.getMessage();
    }
}
