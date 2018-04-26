package in.ogmatech.techstile.drycleanservice.repository;

import in.ogmatech.techstile.drycleanservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
