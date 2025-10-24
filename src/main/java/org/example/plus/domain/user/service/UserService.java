package org.example.plus.domain.user.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.plus.common.entity.User;
import org.example.plus.common.utils.JwtUtil;
import org.example.plus.domain.user.model.dto.UserDto;
import org.example.plus.domain.user.model.request.LoginRequest;
import org.example.plus.domain.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;


    public User save(User user) {
        return userRepository.save(user);
    }

    public String login(LoginRequest request) {

        String username = request.getUsername();
        String password = request.getPassword();

        User user = userRepository.findUserByUsername(username).orElseThrow(
            ()-> new IllegalArgumentException("등록된 사용자가 없습니다.")
        );

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        return jwtUtil.generateToken(user.getUsername(), user.getRoleEnum());

    }

    @Transactional
    public void updateUserEmail(String username, String email) {

        User user = userRepository.findUserByUsername(username).orElseThrow(
            ()-> new IllegalArgumentException("등록된 사용자가 없습니다.")
        );

        user.updateEmail(email);

        userRepository.save(user);


        log.info(" 5번째 : 서비스 레이어 메서드 실행 완료 ");
    }

    @Transactional
    public UserDto updateUserEmailByJpql(String username, String email) {

        User user = userRepository.findUserByUsername(username).orElseThrow(
            ()-> new IllegalArgumentException("등록된 사용자가 없습니다.")
        );

        userRepository.updateUserEmailByJpql(username, email);

        user.updateEmail(email);

        return UserDto.from(user);
    }

    @Transactional
    public UserDto getUserByUsername(String username) {

        User user = userRepository.findUserByUsername(username).orElseThrow(
            () -> new IllegalArgumentException("등록된 사용자가 없습니다.")
        );

        return UserDto.from(user);
    }


    @Transactional
    public void deleteUserByJpql(String username) {
        userRepository.deleteUserByJpql(username);
    }
}
