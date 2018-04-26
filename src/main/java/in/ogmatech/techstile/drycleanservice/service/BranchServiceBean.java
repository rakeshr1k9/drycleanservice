package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.exception.AlreadyExistsException;
import in.ogmatech.techstile.drycleanservice.model.Branch;
import in.ogmatech.techstile.drycleanservice.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Validated
@Transactional
public class BranchServiceBean implements BranchService {

    @Autowired
    BranchRepository branchRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean isExist(Branch branch) {
        return findById(branch.getIdBranch())!=null;
    }

    @Override
    public Branch save(Branch branch) {

        Branch existing = branchRepository.findOne(branch.getIdBranch());

        if (existing != null) {
            throw new AlreadyExistsException(
                    String.format("There already exists a branch with id = %s", branch.getIdBranch()));
        }

        return branchRepository.save(branch);
    }

    @Override
    public Branch findById(Long idBranch) {
        return branchRepository.findOne(idBranch);
    }

    @Override
    public List<Branch> findAll() {
        return branchRepository.findAll();
    }

    @Override
    public Branch update(Branch branch) {
        return branchRepository.save(branch);
    }

    @Override
    public void delete(Long idBranch) {
        branchRepository.delete(idBranch);
    }

    @Override
    public void deleteAll() {
        branchRepository.deleteAll();
    }
}
