package sparta.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserRoleEnum {
    ADMIN("ROLE_ADMIN", "관리자 권한"),
    NORMAL("ROLE_NORMAL", "일반 권한");

    private final String role;
    private final String description;
}
