package in.ogmatech.techstile.drycleanservice.repository;

import in.ogmatech.techstile.drycleanservice.model.OrderType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderTypeRepository extends JpaRepository<OrderType, Long> {
}
