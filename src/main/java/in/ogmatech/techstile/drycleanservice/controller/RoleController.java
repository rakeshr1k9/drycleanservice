package in.ogmatech.techstile.drycleanservice.controller;

import in.ogmatech.techstile.drycleanservice.exception.AlreadyExistsException;
import in.ogmatech.techstile.drycleanservice.model.Role;
import in.ogmatech.techstile.drycleanservice.service.RoleService;
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
public class RoleController {

    @Autowired
    private RoleService roleService;

    /* Create a role */
    @PostMapping("roles")
    public ResponseEntity<Role> createRole(@RequestBody Role role, UriComponentsBuilder ucBuilder) {

        if (roleService.isExist(role)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        roleService.save(role);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("roles/{id}").buildAndExpand(role.getIdRole()).toUri());

        return new ResponseEntity<>(role, headers, HttpStatus.CREATED);
    }

    /* Reading single role */
    @GetMapping(value = "roles/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Role> getRole(@PathVariable("id") long idRole) {

        Role role = roleService.findById(idRole);

        if (role == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    /*Reads all roles*/
    @GetMapping(value = "roles",produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<List<Role>> listAllRoles() {

        List<Role> role = roleService.findAll();

        if (role.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    /*Update a role*/
    @PutMapping("roles/{id}")
    public ResponseEntity<Role> updateRoleFromDB(@PathVariable("id") Long idRole, @RequestBody Role role) {

        Role currentRole = roleService.findById(idRole);

        if (currentRole == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        roleService.update(idRole, role);

        Role updatedRole = roleService.findById(idRole);

        return new ResponseEntity<>(updatedRole, HttpStatus.OK);
    }

    /*Delete a role */
    @DeleteMapping("roles/{id}")
    public ResponseEntity<Role> deleteRoleFromDB(@PathVariable("id") long idRole) {

        Role role = roleService.findById(idRole);

        if (role == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        roleService.delete(idRole);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*Delete all roles*/
    @DeleteMapping("roles")
    public ResponseEntity<Role> deleteAllRoles() {

        roleService.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleRoleAlreadyExistsException(AlreadyExistsException exception) {

        return exception.getMessage();
    }

}
