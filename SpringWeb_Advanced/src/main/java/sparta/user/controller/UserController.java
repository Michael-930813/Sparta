package sparta.user.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import sparta.common.utils.JwtUtil;
import sparta.user.model.request.LoginRequestDto;
import sparta.user.model.request.UserEmailUpdateRequestDto;
import sparta.user.model.response.LoginResponseDto;
import sparta.user.service.UserService;

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
}
