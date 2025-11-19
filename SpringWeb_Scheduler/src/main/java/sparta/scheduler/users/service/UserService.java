package sparta.scheduler.users.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sparta.scheduler.common.exception.UnauthorizedException;
import sparta.scheduler.users.dto.*;
import sparta.scheduler.users.entity.User;
import sparta.scheduler.users.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
// - Properties
    private final UserRepository userRepository;

// - Methods
    // - Create
    @Transactional
    public CreateUserResponse create(CreateUserRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalStateException("이미 가입된 이메일입니다.");
        }
        User user = new User(request);
        User saved = userRepository.save(user);
        return new CreateUserResponse(saved);
    }
    // - Read (All & One)
    @Transactional(readOnly = true)
    public List<GetUserResponse> getAll(String name) {
        List<User> users;

        if (name != null && !name.isBlank()) {
            users = userRepository.findAllByNameOrderByCreatedAtDesc(name);
        } else {
            users = userRepository.findAllByOrderByCreatedAtDesc();
        }

        List<GetUserResponse> dtos = new ArrayList<>();
        for (User user : users) {
            dtos.add(new GetUserResponse(user));
        }

        return dtos;
    }
    @Transactional(readOnly = true)
    public GetUserResponse getOne(Long userId) {
        User user = findUserById(userId);
        return new GetUserResponse(user);
    }
    // - Update
    @Transactional
    public UpdateUserResponse update(Long userId, UpdateUserRequest request) {
        User user = findUserById(userId);
        if (!user.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        user.update(request);
        return new UpdateUserResponse(user);
    }
    // - Delete
    @Transactional
    public void delete(Long userId, DeleteUserRequest request) {
        User user = findUserById(userId);
        if (!user.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        userRepository.delete(user);
    }

    // - Login
    @Transactional
    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(
                () -> new IllegalArgumentException("이메일 또는 비밀번호가 일치하지 않습니다.")
        );

        if (!user.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("이메일 또는 비밀번호가 일치하지 않습니다.");
        }

        return new LoginResponse(user);
    }

// - Common Methods
    // - FindUserFromId
    private User findUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> new IllegalStateException("존재 하지 않는 유저입니다!!")
        );
    }
}
