package org.sparta.scheduler.repository;

import org.sparta.scheduler.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    // - Count By ScheduleId
    Long countByScheduleId(Long scheduleId);
    // - FindAll By ScheduleId Order By CreatedAt DESC
    List<Comment> findAllByScheduleIdOrderByCreatedAtDesc(Long scheduleId);
    // - FindAll By Order By CreatedAt DESC
    List<Comment> findAllByOrderByCreatedAtDesc();
}
