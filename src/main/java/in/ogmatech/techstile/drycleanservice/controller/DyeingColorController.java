package in.ogmatech.techstile.drycleanservice.controller;

import in.ogmatech.techstile.drycleanservice.exception.AlreadyExistsException;
import in.ogmatech.techstile.drycleanservice.model.DyeingColor;
import in.ogmatech.techstile.drycleanservice.service.DyeingColorService;
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
public class DyeingColorController {

    @Autowired
    private DyeingColorService dyeingColorService;

    /* Create a dyeingColor */
    @PostMapping("dyeingColors")
    public ResponseEntity<DyeingColor> createDyeingColor(@RequestBody DyeingColor dyeingColor, UriComponentsBuilder ucBuilder) {

        if (dyeingColorService.isExist(dyeingColor)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        dyeingColorService.save(dyeingColor);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("dyeingColors/{id}").buildAndExpand(dyeingColor.getIdDyeingColor()).toUri());

        return new ResponseEntity<>(dyeingColor, headers, HttpStatus.CREATED);
    }

    /* Reading single dyeingColor */
    @GetMapping(value = "dyeingColors/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DyeingColor> getDyeingColor(@PathVariable("id") long idDyeingColor) {

        DyeingColor dyeingColor = dyeingColorService.findById(idDyeingColor);

        if (dyeingColor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(dyeingColor, HttpStatus.OK);
    }

    /*Reads all dyeingColors*/
    @GetMapping(value = "dyeingColors",produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<List<DyeingColor>> listAllDyeingColors() {

        List<DyeingColor> dyeingColor = dyeingColorService.findAll();

        if (dyeingColor.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(dyeingColor, HttpStatus.OK);
    }

    /*Update a dyeingColor*/
    @PutMapping("dyeingColors/{id}")
    public ResponseEntity<DyeingColor> updateDyeingColorFromDB(@PathVariable("id") Long idDyeingColor, @RequestBody DyeingColor dyeingColor) {

        DyeingColor currentDyeingColor = dyeingColorService.findById(idDyeingColor);

        if (currentDyeingColor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        dyeingColorService.update(idDyeingColor, dyeingColor);

        DyeingColor updatedDyeingColor = dyeingColorService.findById(idDyeingColor);

        return new ResponseEntity<>(updatedDyeingColor, HttpStatus.OK);
    }

    /*Delete a dyeingColor */
    @DeleteMapping("dyeingColors/{id}")
    public ResponseEntity<DyeingColor> deleteDyeingColorFromDB(@PathVariable("id") long idDyeingColor) {

        DyeingColor dyeingColor = dyeingColorService.findById(idDyeingColor);

        if (dyeingColor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        dyeingColorService.delete(idDyeingColor);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*Delete all dyeingColors*/
    @DeleteMapping("dyeingColors")
    public ResponseEntity<DyeingColor> deleteAllDyeingColors() {

        dyeingColorService.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleDyeingColorAlreadyExistsException(AlreadyExistsException exception) {

        return exception.getMessage();
    }
}
