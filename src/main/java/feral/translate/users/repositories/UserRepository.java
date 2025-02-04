package feral.translate.users.repositories;

import feral.translate.users.domain.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends ListCrudRepository<User, Long> {
    @Query("SELECT COUNT(*) > 0 FROM users.users WHERE username = :username")
    boolean existsByUsername(String username);

    @Query("SELECT COUNT(*) > 0 FROM users.users WHERE email = :email")
    boolean existsByEmail(String email);

    @Query("SELECT * FROM users.users WHERE username = :username")
    Optional<User> findByUsername(String username);
}

