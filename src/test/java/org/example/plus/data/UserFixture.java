package org.example.plus.data;

import org.example.plus.common.entity.User;
import org.example.plus.common.enums.UserRoleEnum;

public class UserFixture {

    public static String DEFAULT_USERNAME = "kim-dong";
    public static String DEFAULT_PASSWORD = "1234";
    public static String DEFAULT_EMAIL = "test@test.com";


    public static User createUserAdminRole() {
        return new User(DEFAULT_USERNAME, DEFAULT_PASSWORD, DEFAULT_EMAIL, UserRoleEnum.ADMIN);
    }

    public static User createUserNormalRole() {
        return new User(DEFAULT_USERNAME, DEFAULT_PASSWORD, DEFAULT_EMAIL, UserRoleEnum.NORMAL);
    }
}
