package org.sparta.scheduler.dto;

import lombok.Getter;
import org.sparta.scheduler.entity.Schedule;

import java.time.LocalDateTime;

@Getter
public class GetScheduleResponse {
    // - Property
    private final Long id;
    private final String title;
    private final String description;
    private final String author;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public GetScheduleResponse(Long id, String title, String description, String author, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public GetScheduleResponse(Schedule schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.description = schedule.getDescription();
        this.author = schedule.getAuthor();
        this.createdAt = schedule.getCreatedAt();
        this.modifiedAt = schedule.getModifiedAt();
    }
}
