package org.example.plus.domain.post.controller;

import static org.example.plus.data.UserFixture.DEFAULT_USERNAME;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import jakarta.transaction.Transactional;
import org.example.plus.common.entity.User;
import org.example.plus.common.utils.JwtUtil;
import org.example.plus.data.UserFixture;
import org.example.plus.domain.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class PostControllerTest {

    // 우리가 지금까지 했던것처럼 postman을 통해서 api를 호출하는 행위를 통합 테스트로 진행을 할것임.
    // Postman을 통해서 HTTP 통신을 보내는 것을 통합 테스트에서 진행함.

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    private String token;

    @BeforeEach
    void setUp() {
        User user = UserFixture.createUserAdminRole();
        userRepository.save(user);
        token = jwtUtil.generateToken(user.getUsername(), user.getRoleEnum());
    }

    @Test
    @DisplayName("POST /api/post - 게시글 생성 요청 성공")
    void createPost_통합테스트_success() throws Exception {



        String requestBody =
            """
                {
                    "content" : "통합테스트 게시글 입니다."
                }
            """;

        mockMvc.perform(post("/api/post")
            .contentType(MediaType.APPLICATION_JSON)
            .header("Authorization", token)
            .content(requestBody))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.content").value("통합테스트 게시글 입니다."))
            .andExpect(jsonPath("$.username").value(DEFAULT_USERNAME));


    }


}