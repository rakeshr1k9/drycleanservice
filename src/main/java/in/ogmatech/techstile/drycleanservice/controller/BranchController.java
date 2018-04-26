package in.ogmatech.techstile.drycleanservice.controller;

import in.ogmatech.techstile.drycleanservice.exception.AlreadyExistsException;
import in.ogmatech.techstile.drycleanservice.model.Branch;
import in.ogmatech.techstile.drycleanservice.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class BranchController {

    @Autowired
    private BranchService branchService;

    /* Create a branch */
    @PostMapping("branches")
    public ResponseEntity<Branch> createBook(@RequestBody Branch branch, UriComponentsBuilder ucBuilder) {

        if (branchService.isExist(branch)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        branchService.save(branch);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("branches/{id}").buildAndExpand(branch.getIdBranch()).toUri());

        return new ResponseEntity<>(branch, headers, HttpStatus.CREATED);
    }

    /* Reading single branch */
    @GetMapping(value = "branches/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Branch> getBranch(@PathVariable("id") long idBranch) {

        Branch branch = branchService.findById(idBranch);

        if (branch == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(branch, HttpStatus.OK);
    }

    /*Reads all branches*/
    @GetMapping(value = "branches",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Branch>> listAllBranches() {

        List<Branch> branch = branchService.findAll();

        if (branch.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(branch, HttpStatus.OK);
    }

    /*Update a branch*/
    @PutMapping("branches/{id}")
    public ResponseEntity<Branch> updateBranchFromDB(@PathVariable("id") long idBranch, @RequestBody Branch branch) {

        Branch currentBranch = branchService.findById(idBranch);

        if (currentBranch == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        currentBranch.setBranchCode(branch.getBranchCode());
        currentBranch.setBranchName(branch.getBranchName());
        currentBranch.setBranchPlace(branch.getBranchPlace());
        currentBranch.setIsDeleted(branch.getIsDeleted());

        branchService.update(currentBranch);

        return new ResponseEntity<>(currentBranch, HttpStatus.OK);
    }

    /*Delete a branch */
    @DeleteMapping("branches/{id}")
    public ResponseEntity<Branch> deleteBookFromDB(@PathVariable("id") long idBranch) {

        Branch branch = branchService.findById(idBranch);

        if (branch == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        branchService.delete(idBranch);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*Delete all branches*/
    @DeleteMapping("branches")
    public ResponseEntity<Branch> deleteAllBranches() {

        branchService.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleBranchAlreadyExistsException(AlreadyExistsException exception) {

        return exception.getMessage();
    }
}
