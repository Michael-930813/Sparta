package org.sparta.scheduler.repository;

import org.sparta.scheduler.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {
}
