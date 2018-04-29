package in.ogmatech.techstile.drycleanservice.controller;

import in.ogmatech.techstile.drycleanservice.exception.AlreadyExistsException;
import in.ogmatech.techstile.drycleanservice.model.User;
import in.ogmatech.techstile.drycleanservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

//import static in.ogmatech.techstile.drycleanservice.utility.Common.copyNonNullProperties;

@RestController
@RequestMapping("/api/")
public class UserController {

    @Autowired
    private UserService userService;

    /* Create a user */
    @PostMapping("users")
    public ResponseEntity<User> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {

        if (userService.isExist(user)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        userService.save(user);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("users/{id}").buildAndExpand(user.getIdUser()).toUri());

        return new ResponseEntity<>(user, headers, HttpStatus.CREATED);
    }

    /* Reading single user */
    @GetMapping(value = "users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("id") long idUser) {

        User user = userService.findById(idUser);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /*Reads all users*/
    @GetMapping(value = "users",produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<List<User>> listAllUsers() {

        List<User> user = userService.findAll();

        if (user.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        for(User userLink:user){
            Link self = ControllerLinkBuilder.linkTo(UserController.class).slash(userLink.getIdUser()).withSelfRel().withType("GET");
            userLink.add(self);
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /*Update a user*/
    @PutMapping("users/{id}")
    public ResponseEntity<User> updateUserFromDB(@PathVariable("id") Long idUser, @RequestBody User user) {

        User currentUser = userService.findById(idUser);

        if (currentUser == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


       /* //if request body doesn't supplied id this will going to help
        user.setIdUser(idUser);

        //it will compare request body with entity model to manage null values
        copyNonNullProperties(user, currentUser);*/

        userService.update(idUser, user);

        User updatedUser = userService.findById(idUser);

        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    /*Delete a user */
    @DeleteMapping("users/{id}")
    public ResponseEntity<User> deleteUserFromDB(@PathVariable("id") long idUser) {

        User user = userService.findById(idUser);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        userService.delete(idUser);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*Delete all users*/
    @DeleteMapping("users")
    public ResponseEntity<User> deleteAllUsers() {

        userService.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleUserAlreadyExistsException(AlreadyExistsException exception) {

        return exception.getMessage();
    }


}
