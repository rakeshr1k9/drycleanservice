package in.ogmatech.techstile.drycleanservice.repository;

import in.ogmatech.techstile.drycleanservice.model.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentTypeRepository extends JpaRepository<PaymentType, Long> {
}
