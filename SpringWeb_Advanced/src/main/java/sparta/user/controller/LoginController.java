package sparta.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sparta.user.model.request.LoginRequestDto;
import sparta.user.model.response.LoginResponseDto;
import sparta.user.service.UserService;

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
