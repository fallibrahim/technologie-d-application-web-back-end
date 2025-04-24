package sn.unchk.user_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.unchk.user_service.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
