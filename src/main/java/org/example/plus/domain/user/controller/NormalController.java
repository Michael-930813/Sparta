package org.example.plus.domain.user.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/normal")
@RequiredArgsConstructor
@Slf4j
public class NormalController {

    @GetMapping("/get")
    public String getNormalInfo(@AuthenticationPrincipal User user) {
        log.info(user.getUsername());
        return "일반 사용자 페이지에 접속 성공";
    }
}
