package pl.mumanski.offertlyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mumanski.offertlyapi.model.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUsernameAndPassword(String username, String password);
}
