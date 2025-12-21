package org.example.springweb_restapi.repository;

import org.example.springweb_restapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}