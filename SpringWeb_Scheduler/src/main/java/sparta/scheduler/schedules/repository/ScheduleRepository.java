package sparta.scheduler.schedules.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sparta.scheduler.schedules.entity.Schedule;
import sparta.scheduler.users.entity.User;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    // - Find All By, Order By CreatedAt DESC
    List<Schedule> findAllByOrderByCreatedAtDesc();
    // - Find All By User, Order By CreatedAt DESC
    List<Schedule> findAllByUserIdOrderByCreatedAtDesc(Long userId);
}
