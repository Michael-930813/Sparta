package sparta.scheduler.users.dto;

import lombok.Getter;
import sparta.scheduler.users.entity.User;

@Getter
public class LoginResponse {
// - Properties
    private final Long userId;
    private final String name;
    private final String email;

// - Methods
    // - Constructor
    public LoginResponse(Long userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }
    public LoginResponse(User user) {
        this.userId = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }
}
