package org.sparta.scheduler.dto;

import lombok.Getter;
import org.sparta.scheduler.entity.Comment;

import java.time.LocalDateTime;

@Getter
public class GetCommentResponse {
// - Property
    private final Long id;
    private final String comment;
    private final String author;
    private final Long scheduleId;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    // - Constructor
    public GetCommentResponse(Long id, String comment, String author, Long ScheduleId, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.comment = comment;
        this.author = author;
        this.scheduleId = ScheduleId;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
    public GetCommentResponse(Comment comment) {
        this.id = comment.getId();
        this.comment = comment.getComment();
        this.author = comment.getAuthor();
        this.scheduleId = comment.getSchedule().getId();
        this.createdAt = comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();
    }
}