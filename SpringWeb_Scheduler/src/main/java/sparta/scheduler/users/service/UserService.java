package sparta.scheduler.users.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    public CreateUserResponse save(CreateUserRequest request) {
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
        user.update(request);
        return new UpdateUserResponse(user);
    }
    // - Delete
    @Transactional
    public void delete(Long userId) {
        User user = findUserById(userId);
        userRepository.delete(user);
    }

    // - FindUserFromId
    public User findUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> new IllegalStateException("존재 하지 않는 유저입니다!!")
        );
    }
}
