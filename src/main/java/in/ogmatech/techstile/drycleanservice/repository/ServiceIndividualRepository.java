package in.ogmatech.techstile.drycleanservice.repository;

import in.ogmatech.techstile.drycleanservice.model.ServiceIndividual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceIndividualRepository extends JpaRepository<ServiceIndividual, Long> {
}
