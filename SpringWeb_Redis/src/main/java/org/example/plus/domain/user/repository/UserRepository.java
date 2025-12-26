package org.example.plus.domain.user.repository;

import java.util.Optional;
import org.example.plus.common.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long>, UserCustomRepository {


    Optional<User> findUserByUsername(String username);

    @Modifying
    @Query("UPDATE User u SET u.email = :email WHERE u.username = :username")
    void updateUserEmailByJpql(@Param("username") String username , @Param("email") String email);

    @Modifying
    @Query("DELETE FROM User u WHERE u.username = :username")
    void deleteUserByJpql(@Param("username") String username);
}
