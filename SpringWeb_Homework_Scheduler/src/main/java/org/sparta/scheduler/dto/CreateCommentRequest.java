package org.sparta.scheduler.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CreateCommentRequest {
    @NotBlank(message = "댓글 내용은 필수 입력값입니다.")
    @Size(max = 200, message = "댓글 내용은 200자 이내여야 합니다.")
    private String comment;
    @NotBlank(message = "작성자명은 필수 입력값입니다.")
    private String author;
    @NotBlank(message = "비밀번호는 필수 입력값입니다.")
    private String password;
}
