package sparta.scheduler.users.repository;

import org.springframework.data.repository.CrudRepository;
import sparta.scheduler.users.entity.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    // - Find All By Name, Order By CreatedAt DESC
    List<User> findAllByNameOrderByCreatedAtDesc(String name);
    // - Find All, Order By CreatedAt DESC
    List<User> findAllByOrderByCreatedAtDesc();
}
