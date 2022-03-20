package pl.mumanski.offertlyapi.userManagement;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUsernameAndPassword(String username, String password);
}
