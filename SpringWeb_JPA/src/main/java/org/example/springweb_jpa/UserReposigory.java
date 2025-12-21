package org.example.springweb_jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReposigory extends JpaRepository<User,Long> {
}
