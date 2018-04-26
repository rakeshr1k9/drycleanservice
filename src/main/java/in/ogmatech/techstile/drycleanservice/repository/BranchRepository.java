package in.ogmatech.techstile.drycleanservice.repository;

import in.ogmatech.techstile.drycleanservice.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long>{
}
