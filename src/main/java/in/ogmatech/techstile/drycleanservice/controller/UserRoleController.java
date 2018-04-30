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

    /* Create a userRole */
    @PostMapping("userRoles")
    public ResponseEntity<UserRole> createUserRole(@RequestBody UserRole userRole, UriComponentsBuilder ucBuilder) {

        if (userRoleService.isExist(userRole)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        userRoleService.save(userRole);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("userRoles/{id}").buildAndExpand(userRole.getIdUserRole()).toUri());

        return new ResponseEntity<>(userRole, headers, HttpStatus.CREATED);
    }

    /* Reading single userRole */
    @GetMapping(value = "userRoles/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserRole> getUserRole(@PathVariable("id") long idUserRole) {

        UserRole userRole = userRoleService.findById(idUserRole);

        if (userRole == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(userRole, HttpStatus.OK);
    }

    /*Reads all userRoles*/
    @GetMapping(value = "userRoles",produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<List<UserRole>> listAllUserRoles() {

        List<UserRole> userRole = userRoleService.findAll();

        if (userRole.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(userRole, HttpStatus.OK);
    }

    /*Update a userRole*/
    @PutMapping("userRoles/{id}")
    public ResponseEntity<UserRole> updateUserRoleFromDB(@PathVariable("id") Long idUserRole, @RequestBody UserRole userRole) {

        UserRole currentUserRole = userRoleService.findById(idUserRole);

        if (currentUserRole == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        userRoleService.update(idUserRole, userRole);

        UserRole updatedUserRole = userRoleService.findById(idUserRole);

        return new ResponseEntity<>(updatedUserRole, HttpStatus.OK);
    }

    /*Delete a userRole */
    @DeleteMapping("userRoles/{id}")
    public ResponseEntity<UserRole> deleteUserRoleFromDB(@PathVariable("id") long idUserRole) {

        UserRole userRole = userRoleService.findById(idUserRole);

        if (userRole == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        userRoleService.delete(idUserRole);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*Delete all userRoles*/
    @DeleteMapping("userRoles")
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
