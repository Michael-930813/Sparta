package org.sparta.scheduler.dto;

import lombok.Getter;

@Getter
public class CreateCommentRequest {
    private String comment;
    private String author;
    private String password;
}
