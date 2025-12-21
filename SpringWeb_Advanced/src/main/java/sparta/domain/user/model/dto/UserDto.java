package sparta.domain.user.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sparta.common.entity.User;
import sparta.common.enums.UserRoleEnum;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
// - Properties
    private long id;
    private String username;
    private String email;
    private UserRoleEnum roleEnum;

// - Methods
    public static UserDto from(User user) {
        return new UserDto(user.getId(), user.getUsername(), user.getEmail(), user.getRole());
    }
}
