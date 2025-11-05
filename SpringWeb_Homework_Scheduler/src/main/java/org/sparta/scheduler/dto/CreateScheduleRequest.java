package org.sparta.scheduler.dto;

import lombok.Getter;

@Getter
public class CreateScheduleRequest {
    private String title;
    private String description;
    private String author;
    private String password;
}
