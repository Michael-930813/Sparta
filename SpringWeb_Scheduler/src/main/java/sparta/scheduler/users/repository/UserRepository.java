package sparta.scheduler.users.repository;

import org.springframework.data.repository.CrudRepository;
import sparta.scheduler.users.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    // - Find All By Name, Order By CreatedAt DESC
    List<User> findAllByNameOrderByCreatedAtDesc(String name);
    // - Find All By, Order By CreatedAt DESC
    List<User> findAllByOrderByCreatedAtDesc();
    // - Check Email Duplication
    boolean existsByEmail(String eamil);
}