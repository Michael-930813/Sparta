package sparta.scheduler.users.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginRequest {
// - Properties
    private String email;
    private String password;
}
