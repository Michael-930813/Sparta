package sparta.scheduler.users.dto;

import lombok.Getter;

@Getter
public class UpdateUserRequest {
    private String name;
    private String email;
}