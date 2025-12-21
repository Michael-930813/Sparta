package org.example.plus.domain.user.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.plus.common.entity.User;
import org.example.plus.common.enums.UserRoleEnum;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private long id;
    private String username;;
    private String email;
    private UserRoleEnum roleEnum;

    public static UserDto from(User user) {
        return new UserDto(user.getId(), user.getUsername(), user.getEmail(), user.getRoleEnum());
    }


}
