package org.example.plus.domain.user.controller;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.plus.common.utils.JwtUtil;
import org.example.plus.domain.user.model.dto.UserDto;
import org.example.plus.domain.user.model.request.UpdateUserEmailRequest;
import org.example.plus.domain.user.model.request.UserSearchRequest;
import org.example.plus.domain.user.model.response.UserSearchResponse;
import org.example.plus.domain.user.service.UserService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final JwtUtil jwtUtil;
    private final UserService userService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/get")
    public String getUserInfo(@AuthenticationPrincipal User user) {

        log.info(user.getUsername());
        return user.getUsername();
    }


    @GetMapping("/validate")
    public ResponseEntity<Boolean> checkValidate(HttpServletRequest request) {

        String headerToken = request.getHeader("Authorization");

        String jwt = headerToken.substring(7);

        log.info(jwt);

        Boolean validate = jwtUtil.validateToken(jwt);

        return ResponseEntity.ok(validate);
    }

    @GetMapping("/username")
    public ResponseEntity<String> getUsername(HttpServletRequest request) {
        String headerToken = request.getHeader("Authorization");

        String jwt = headerToken.substring(7);

        log.info(jwt);

        String username = jwtUtil.extractUsername(jwt);

        return ResponseEntity.ok(username);
    }

    @PutMapping("/{username}/email")
    public ResponseEntity<String> updateEmail(@PathVariable String username, @RequestBody UpdateUserEmailRequest request) {
        log.info(" 3번째 : interceptor를 통과후 controller 로직 수행");

        userService.updateUserEmail(username, request.getEmail());

        log.info("7번째 : controller 수행 완료");

        return ResponseEntity.ok("수정완료");
    }

    // 이메일을 수정하는 것은 본인만 가능하거죠?


    // JPQL을 통한 CRUD 실습

    // 1. 단계 조회하기
    // 2. 수정하기
    // 3. 삭제하기

    @GetMapping("/{username}/jpql")
    public ResponseEntity<UserDto> getUserByUsernameWithJpql(@PathVariable String username) {
        return ResponseEntity.ok(userService.getUserByUsername(username));
    }

    @PutMapping("/{username}/email/jpql")
    public ResponseEntity<UserDto> updateEmailByJpql(@PathVariable String username, @RequestBody UpdateUserEmailRequest request) {

        userService.updateUserEmailByJpql(username, request.getEmail());


        return ResponseEntity.ok(userService.updateUserEmailByJpql(username, request.getEmail()));
    }

    @DeleteMapping("/{username}/jpql")
    public ResponseEntity<String> deleteUserByJpql(@PathVariable String username) {
        userService.deleteUserByJpql(username);
        return ResponseEntity.ok("삭제완료");
    }

    @GetMapping("/search")
    public ResponseEntity<List<UserSearchResponse>> searchUserList(
        UserSearchRequest request
    ) {
        return ResponseEntity.ok(userService.searchUserList(request));
    }

    @GetMapping("/search/page")
    public ResponseEntity<Page<UserSearchResponse>> searchUserPage(
        UserSearchRequest request,
        Pageable pageable

    ) {
        return ResponseEntity.ok(userService.searchUserPage(request, pageable));
    }

}
