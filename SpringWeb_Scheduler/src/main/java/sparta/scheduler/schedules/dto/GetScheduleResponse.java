package sparta.scheduler.schedules.dto;

import lombok.Getter;
import sparta.scheduler.schedules.entity.Schedule;

import java.time.LocalDateTime;

@Getter
public class GetScheduleResponse {
// - Properties
    private final Long id;
    private final Long userId;
    private final String title;
    private final String description;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

// - Methods
    // - Constructor
    public GetScheduleResponse(Long id, Long userId, String title, String description, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
    public GetScheduleResponse(Schedule schedule) {
        this.id = schedule.getId();
        this.userId = schedule.getUser().getId();
        this.title = schedule.getTitle();
        this.description = schedule.getDescription();
        this.createdAt = schedule.getCreatedAt();
        this.modifiedAt = schedule.getModifiedAt();
    }
}
