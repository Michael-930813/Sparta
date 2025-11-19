package sparta.scheduler.users.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sparta.scheduler.users.dto.*;
import sparta.scheduler.users.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
// - Properties
    private final UserService userService;

// - Methods
    // - Create
    @PostMapping("/users")
    public ResponseEntity<CreateUserResponse> create(@RequestBody CreateUserRequest request) {
        CreateUserResponse result = userService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    // - Read
    @GetMapping("/users")
    public ResponseEntity<List<GetUserResponse>> getAll(@RequestParam(required = false) String name) {
        List<GetUserResponse> result = userService.getAll(name);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @GetMapping("/users/{userId}")
    public ResponseEntity<GetUserResponse> getOne(@PathVariable Long userId) {
        GetUserResponse result = userService.getOne(userId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    // - Update
    @PutMapping("/users/{userId}")
    public ResponseEntity<UpdateUserResponse> update(
            @PathVariable Long userId,
            @RequestBody UpdateUserRequest request) {
        UpdateUserResponse result = userService.update(userId, request);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    // - Delete
    @DeleteMapping("/users/{userId}")
    public String delete(
            @PathVariable Long userId,
            @RequestBody DeleteUserRequest request) {
        userService.delete(userId, request);
        return "일정이 성공적으로 삭제되었습니다.";
    }
}
