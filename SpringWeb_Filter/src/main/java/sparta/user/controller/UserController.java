package sparta.user.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sparta.common.utils.JwtUtil;
import sparta.user.model.response.LoginResponse;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final JwtUtil jwtUtil;

    @GetMapping("/get")
    public String getUserInfo(HttpServletRequest request) {
        String username = request.getAttribute("username").toString();
        log.info(username);
        return username;
    }

    // 토큰 생성 테스트
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login() {

        String token  = jwtUtil.generateToken("kim");

        return ResponseEntity.ok(new LoginResponse(token));
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

}
