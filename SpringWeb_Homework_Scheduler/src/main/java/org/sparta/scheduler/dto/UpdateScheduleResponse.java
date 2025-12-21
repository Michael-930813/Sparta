package org.sparta.scheduler.dto;

import lombok.Getter;
import org.sparta.scheduler.entity.Schedule;

import java.time.LocalDateTime;

@Getter
public class UpdateScheduleResponse {
    // - Property
    private final Long id;
    private final String title;
    private final String author;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    // - Constructor
    public UpdateScheduleResponse(Long id, String title, String author, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
    public UpdateScheduleResponse(Schedule schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.author = schedule.getAuthor();
        this.createdAt = schedule.getCreatedAt();
        this.modifiedAt = schedule.getModifiedAt();
    }
}
