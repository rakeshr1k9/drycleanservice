package in.ogmatech.techstile.drycleanservice.controller;

import in.ogmatech.techstile.drycleanservice.exception.AlreadyExistsException;
import in.ogmatech.techstile.drycleanservice.model.ItemDyeingColor;
import in.ogmatech.techstile.drycleanservice.service.ItemDyeingColorService;
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
public class ItemDyeingColorController {

    @Autowired
    private ItemDyeingColorService itemDyeingColorService;

    /* Create a itemDyeingColor */
    @PostMapping("itemDyeingColors")
    public ResponseEntity<ItemDyeingColor> createItemDyeingColor(@RequestBody ItemDyeingColor itemDyeingColor, UriComponentsBuilder ucBuilder) {

        if (itemDyeingColorService.isExist(itemDyeingColor)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        itemDyeingColorService.save(itemDyeingColor);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("itemDyeingColors/{id}").buildAndExpand(itemDyeingColor.getIdItemDyeingColor()).toUri());

        return new ResponseEntity<>(itemDyeingColor, headers, HttpStatus.CREATED);
    }

    /* Reading single itemDyeingColor */
    @GetMapping(value = "itemDyeingColors/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ItemDyeingColor> getItemDyeingColor(@PathVariable("id") long idItemDyeingColor) {

        ItemDyeingColor itemDyeingColor = itemDyeingColorService.findById(idItemDyeingColor);

        if (itemDyeingColor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(itemDyeingColor, HttpStatus.OK);
    }

    /*Reads all itemDyeingColors*/
    @GetMapping(value = "itemDyeingColors",produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<List<ItemDyeingColor>> listAllItemDyeingColors() {

        List<ItemDyeingColor> itemDyeingColor = itemDyeingColorService.findAll();

        if (itemDyeingColor.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(itemDyeingColor, HttpStatus.OK);
    }

    /*Update a itemDyeingColor*/
    @PutMapping("itemDyeingColors/{id}")
    public ResponseEntity<ItemDyeingColor> updateItemDyeingColorFromDB(@PathVariable("id") Long idItemDyeingColor, @RequestBody ItemDyeingColor itemDyeingColor) {

        ItemDyeingColor currentItemDyeingColor = itemDyeingColorService.findById(idItemDyeingColor);

        if (currentItemDyeingColor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        itemDyeingColorService.update(idItemDyeingColor, itemDyeingColor);

        ItemDyeingColor updatedItemDyeingColor = itemDyeingColorService.findById(idItemDyeingColor);

        return new ResponseEntity<>(updatedItemDyeingColor, HttpStatus.OK);
    }

    /*Delete a itemDyeingColor */
    @DeleteMapping("itemDyeingColors/{id}")
    public ResponseEntity<ItemDyeingColor> deleteItemDyeingColorFromDB(@PathVariable("id") long idItemDyeingColor) {

        ItemDyeingColor itemDyeingColor = itemDyeingColorService.findById(idItemDyeingColor);

        if (itemDyeingColor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        itemDyeingColorService.delete(idItemDyeingColor);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*Delete all itemDyeingColors*/
    @DeleteMapping("itemDyeingColors")
    public ResponseEntity<ItemDyeingColor> deleteAllItemDyeingColors() {

        itemDyeingColorService.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleItemDyeingColorAlreadyExistsException(AlreadyExistsException exception) {

        return exception.getMessage();
    }
}
