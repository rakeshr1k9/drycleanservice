package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.Branch;

import java.util.List;

public interface BranchService {

    boolean isExist(Branch branch);

    Branch save(Branch branch);

    Branch findById(Long idBranch);

    List<Branch> findAll();

    Branch update(Branch branch);

    void delete(Long idBranch);

    void deleteAll();
}
