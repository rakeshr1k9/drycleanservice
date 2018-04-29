package in.ogmatech.techstile.drycleanservice.controller;

import in.ogmatech.techstile.drycleanservice.exception.AlreadyExistsException;
import in.ogmatech.techstile.drycleanservice.model.UserRole;
import in.ogmatech.techstile.drycleanservice.service.UserRoleService;
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
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    /* Create a userUserRole */
    @PostMapping("userUserRoles")
    public ResponseEntity<UserRole> createUserRole(@RequestBody UserRole userUserRole, UriComponentsBuilder ucBuilder) {

        if (userRoleService.isExist(userUserRole)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        userRoleService.save(userUserRole);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("userUserRoles/{id}").buildAndExpand(userUserRole.getIdUserRole()).toUri());

        return new ResponseEntity<>(userUserRole, headers, HttpStatus.CREATED);
    }

    /* Reading single userUserRole */
    @GetMapping(value = "userUserRoles/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserRole> getUserRole(@PathVariable("id") long idUserRole) {

        UserRole userUserRole = userRoleService.findById(idUserRole);

        if (userUserRole == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(userUserRole, HttpStatus.OK);
    }

    /*Reads all userUserRoles*/
    @GetMapping(value = "userUserRoles",produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<List<UserRole>> listAllUserRoles() {

        List<UserRole> userUserRole = userRoleService.findAll();

        if (userUserRole.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(userUserRole, HttpStatus.OK);
    }

    /*Update a userUserRole*/
    @PutMapping("userUserRoles/{id}")
    public ResponseEntity<UserRole> updateUserRoleFromDB(@PathVariable("id") Long idUserRole, @RequestBody UserRole userUserRole) {

        UserRole currentUserRole = userRoleService.findById(idUserRole);

        if (currentUserRole == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        userRoleService.update(idUserRole, userUserRole);

        UserRole updatedUserRole = userRoleService.findById(idUserRole);

        return new ResponseEntity<>(updatedUserRole, HttpStatus.OK);
    }

    /*Delete a userUserRole */
    @DeleteMapping("userUserRoles/{id}")
    public ResponseEntity<UserRole> deleteUserRoleFromDB(@PathVariable("id") long idUserRole) {

        UserRole userUserRole = userRoleService.findById(idUserRole);

        if (userUserRole == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        userRoleService.delete(idUserRole);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*Delete all userUserRoles*/
    @DeleteMapping("userUserRoles")
    public ResponseEntity<UserRole> deleteAllUserRoles() {

        userRoleService.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleUserRoleAlreadyExistsException(AlreadyExistsException exception) {

        return exception.getMessage();
    }
}
