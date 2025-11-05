package org.sparta.scheduler.repository;

import org.sparta.scheduler.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {
    // - Find All By Author, Order By ModifiedAt DESC
    List<Schedule> findAllByAuthorOrderByModifiedAtDesc(String author);
    // - Find All, Order By ModifiedAt DESC
    List<Schedule> findAllByOrderByModifiedAtDesc();
}