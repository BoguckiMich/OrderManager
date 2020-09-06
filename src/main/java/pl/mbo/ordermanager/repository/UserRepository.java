package pl.mbo.ordermanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mbo.ordermanager.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByFirstName(String fname);
}
