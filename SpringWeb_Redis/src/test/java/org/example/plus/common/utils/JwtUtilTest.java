package org.example.plus.common.utils;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.example.plus.common.utils.JwtUtil.BEARER_PREFIX;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import org.example.plus.common.enums.UserRoleEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

class JwtUtilTest {

    // JwtUtil 을 테스트 할거다

    private JwtUtil jwtUtil;

    private static final String SECRET_KEY = "myscertkeyfortestcodepracticemyscertkeyfortestcodepractice";

    // JwtUtil을 초기화 시켜줄것이고
    @BeforeEach
    void setUp() {
        jwtUtil = new JwtUtil();
        ReflectionTestUtils.setField(jwtUtil, "secretKeyString", SECRET_KEY );
        jwtUtil.init();
    }

    // JWT 토큰 생성해주는 메서드
    @Test
    @DisplayName("JWT 토큰 생성 시 username과 role 정보가 정상적으로 포함이 되었는지 테스트 ")
    void generateToken_정상케이스() {

        // given
        String username = "kim-dong";
        UserRoleEnum role = UserRoleEnum.ADMIN;
        String fail_username = "dong-kim";

        // when
        String jwtToken = jwtUtil.generateToken(username,role);
        String jwt = jwtToken.substring(BEARER_PREFIX.length());

        // then
        // 1단계 jwtToken 시작이 Bearer 로 시작하는지 검증해줄거고

        assertThat(jwtToken).startsWith(BEARER_PREFIX);
        JwtParser parser = (JwtParser) ReflectionTestUtils.getField(jwtUtil, "parser");

        // 2단계 jwt 가 유효한지 검증을 해줄것입니다.
        assert parser != null;
        Claims claims = parser.parseSignedClaims(jwt).getPayload();

        assertThat(claims.get("username", String.class)).isEqualTo(username);
        assertThat(claims.get("auth", String.class)).isEqualTo(role.name());

    }

    @Test
    @DisplayName("유효한 토큰인지 아닌지 검사 유효하면 true 반환 - 성공케이스")
    void validateToken_성공케이스() {
        // 유효한 토큰이 들어온 경우 그 토큰이 유효한지 아닌지 검사

        // given
        String username = "kim-dong";
        UserRoleEnum role = UserRoleEnum.ADMIN;

        String token = jwtUtil.generateToken(username, role)
            .substring(BEARER_PREFIX.length());


        // when
        boolean result = jwtUtil.validateToken(token);

        // then
        assertThat(result).isTrue();

    }

    @Test
    @DisplayName("유효한 토큰인지 아닌지 검사 유효하면 true 반환 - 실패 케이스 - 잘못된 jwt 토큰 제공")
    void validateToken_실패케이스_01() {

        // given
        String token = "thisiswrongtoken";

        // when
        boolean result = jwtUtil.validateToken(token);

        // then
        assertThat(result).isFalse();
    }

}