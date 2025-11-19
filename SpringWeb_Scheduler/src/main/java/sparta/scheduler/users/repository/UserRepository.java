package sparta.scheduler.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sparta.scheduler.users.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // - Find All By Name, Order By CreatedAt DESC
    List<User> findAllByNameOrderByCreatedAtDesc(String name);
    // - Find All By, Order By CreatedAt DESC
    List<User> findAllByOrderByCreatedAtDesc();
    // - Check Email Duplication
    boolean existsByEmail(String eamil);
    // - Find By Email
    Optional<User> findByEmail(String email);
}