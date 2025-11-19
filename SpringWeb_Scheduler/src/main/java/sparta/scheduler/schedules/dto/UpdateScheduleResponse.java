package sparta.scheduler.schedules.dto;

import lombok.Getter;
import sparta.scheduler.schedules.entity.Schedule;

import java.time.LocalDateTime;

@Getter
public class UpdateScheduleResponse {
// - Properties
    private final Long id;
    private final String author;
    private final String title;
    private final String description;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

// - Methods
    // - Constructor
    public UpdateScheduleResponse(Long id, String author, String title, String description, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
    public UpdateScheduleResponse(Schedule schedule) {
        this.id = schedule.getId();
        this.author = schedule.getAuthor();
        this.title = schedule.getTitle();
        this.description = schedule.getDescription();
        this.createdAt = schedule.getCreatedAt();
        this.modifiedAt = schedule.getModifiedAt();
    }
}
