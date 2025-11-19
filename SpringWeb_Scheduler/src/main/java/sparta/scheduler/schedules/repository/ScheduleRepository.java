package sparta.scheduler.schedules.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sparta.scheduler.schedules.entity.Schedule;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    // - Find All By Author, Order By CreatedAt DESC
    List<Schedule> findAllByAuthorOrderByCreatedAtDesc(String author);
    // - Find All, Order By CreatedAt DESC
    List<Schedule> findAllByOrderByCreatedAtDesc();
}
