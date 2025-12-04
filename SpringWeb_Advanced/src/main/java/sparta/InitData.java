package sparta;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import sparta.common.entity.User;
import sparta.common.enums.UserRoleEnum;
import sparta.user.service.UserService;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InitData {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    @PostConstruct
    @Transactional
    public void init() {
        List<User> productList =
                List.of(
                        new User("테스트",passwordEncoder.encode("1234"),"user1@sparta.com", UserRoleEnum.NORMAL),
                        new User("트스테",passwordEncoder.encode("1234"),"user2@sparta.com",UserRoleEnum.ADMIN)
                );
        for (User product : productList) {
            userService.save(product);
        }
    }
}
