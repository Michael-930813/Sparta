package org.example.plus.domain.user.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.plus.common.enums.UserRoleEnum;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserSearchResponse {

    private String username;
    private String email;
    private UserRoleEnum role;
}
