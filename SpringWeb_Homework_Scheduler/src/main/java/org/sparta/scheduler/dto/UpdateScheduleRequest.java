package org.sparta.scheduler.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UpdateScheduleRequest {
    @NotBlank(message = "일정 제목은 필수 입력값입니다.")
    @Size(max = 30, message = "제목은 30자 이내여야 합니다.")
    private String title;
    @NotBlank(message = "작성자명은 필수 입력값입니다.")
    private String author;
    @NotBlank(message = "비밀번호는 필수 입력값입니다.")
    private String password;
}