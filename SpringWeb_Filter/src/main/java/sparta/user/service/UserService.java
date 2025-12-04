package sparta.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sparta.common.entity.User;
import sparta.common.utils.JwtUtil;
import sparta.user.model.request.LoginRequestDto;
import sparta.user.repository.UserRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
// - Properties
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

// - Methods
    // - Login
    public String login(LoginRequestDto request) {
        String username = request.getUsername();
        String password = request.getPassword();

        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new IllegalArgumentException("등록된 사용자가 없습니다")
        );

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다");
        }

        return jwtUtil.generateToken(user.getUsername(), user.getRole());
    }

    // - InitData Save
    public User save(User user) { return userRepository.save(user); }

    // -
    @Transactional
    public void updateUserEmail(String username, String email) {
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new IllegalArgumentException("등록된 사용자가 없습니다")
        );

        user.updateEmail(email);
    }
}
