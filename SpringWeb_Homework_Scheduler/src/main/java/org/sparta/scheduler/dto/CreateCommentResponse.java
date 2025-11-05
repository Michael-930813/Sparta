package org.sparta.scheduler.dto;

import lombok.Getter;
import org.sparta.scheduler.entity.Comment;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class CreateCommentResponse {
    // - Property
    private final Long id;
    private final String comment;
    private final String author;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    // - Constructor
    public CreateCommentResponse(Long id, String comment, String author, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.comment = comment;
        this.author = author;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
    public CreateCommentResponse(Comment comment) {
        this.id = comment.getId();
        this.comment = comment.getComment();
        this.author = comment.getAuthor();
        this.createdAt = comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();
    }
}
