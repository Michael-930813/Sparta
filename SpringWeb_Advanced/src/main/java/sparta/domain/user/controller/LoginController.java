package sparta.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sparta.domain.user.model.request.LoginRequestDto;
import sparta.domain.user.model.response.LoginResponseDto;
import sparta.domain.user.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LoginController {
// - Properties
    private final UserService userService;

// - Methods
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(
            @RequestBody LoginRequestDto request) {
        // - Create Token
        String token = userService.login(request);
        // - Return Token
        return ResponseEntity.ok(new LoginResponseDto(token));
    }
}
