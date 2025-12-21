package sparta.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sparta.common.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // - Find User by Username
    Optional<User> findByUsername(String username);

    // - JPQL Find User By Username
    @Query("SELECT u FROM User u WHERE u.username = :username")
    Optional<User> findByUsernameByJpql(String username);

    @Modifying
    @Query("UPDATE User u SET u.email = :email WHERE u.username = :username")
    void updateUserEmailByJpql(@Param("username") String username, @Param("email") String email);

    @Modifying
    @Query("DELETE FROM User u WHERE u.username = :username")
    void deleteUserByJpql(String username);
}
