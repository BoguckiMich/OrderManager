package pl.mbo.ordermanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mbo.ordermanager.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
