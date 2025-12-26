package org.example.plus.domain.user.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.plus.common.enums.UserRoleEnum;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserSearchRequest {

    private String username;
    private String email;
    private UserRoleEnum role;
}
