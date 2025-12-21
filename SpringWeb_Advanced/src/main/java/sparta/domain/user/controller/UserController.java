package sparta.domain.user.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import sparta.common.utils.JwtUtil;
import sparta.domain.user.model.dto.UserDto;
import sparta.domain.user.model.request.UserEmailUpdateRequestDto;
import sparta.domain.user.service.UserService;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {
// - Properties
    private final JwtUtil jwtUtil;
    private final UserService userService;

// - Methods
    @GetMapping("/get")
    @PreAuthorize("hasRole('NORMAL')")
    public String getUserInfo(@AuthenticationPrincipal User user) {
        log.info(user.getUsername());
        return "유저 컨트롤러에 접근 하였습니다.";
    }

    // 토큰 검증 테스트
    @GetMapping("/validate")
    public ResponseEntity<Boolean> checkValidate(HttpServletRequest request) {

        String authorizationHeader = request.getHeader("Authorization");

        String jwt = authorizationHeader.substring(7);

        Boolean validate = jwtUtil.validateToken(jwt);

        return ResponseEntity.ok(validate);
    }

    // 토큰 복호화 테스트
    @GetMapping("/username")
    public ResponseEntity<String> getUsername(HttpServletRequest request) {

        String authorizationHeader = request.getHeader("Authorization");

        String jwt = authorizationHeader.substring(7);

        String username = jwtUtil.extractUsername(jwt);

        return ResponseEntity.ok(username);
    }

    // - Email Update
    @PutMapping("/{username}/email")
    public String updateEmail(
            @PathVariable String username,
            @RequestBody UserEmailUpdateRequestDto dto) {
        userService.updateUserEmail(username, dto.getEmail());
        return "수정 완료.";
    }

    // - JPQL을 통한 CRUD 실습
    // - Read
    @GetMapping("/{username}/jpql")
    public ResponseEntity<UserDto> getUserByUsernameByJpql(@PathVariable String username) {
        return ResponseEntity.ok(userService.getUserByUsernameByJpql(username));
    }
    // - Update
    @PutMapping("/{username}/email/jpql")
    public ResponseEntity<UserDto> updateEmailByJpql(@PathVariable String username, @RequestBody UserEmailUpdateRequestDto dto) {
        userService.updateUserEmailByJpql(username, dto.getEmail());

        return ResponseEntity.ok(userService.updateUserEmailByJpql(username, dto.getEmail()));
    }
    // - Delete
    @DeleteMapping("/{username}/jpql")
    public ResponseEntity<String> deleteUserByJpql(@PathVariable String username) {
        userService.deleteUserByJpql(username);
        return ResponseEntity.ok("삭제완료");
    }
}
