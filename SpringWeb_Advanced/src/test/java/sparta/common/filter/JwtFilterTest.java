package sparta.common.filter;

import static org.assertj.core.api.Assertions.assertThat;

import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;
import sparta.common.enums.UserRoleEnum;
import sparta.common.utils.JwtUtil;

import static sparta.common.utils.JwtUtil.BEARER_PREFIX;

class JwtFilterTest {
// - Properties
    private JwtUtil jwtUtil;

    private static final String SECRET_KEY = "IfthisgetsstolenitsabigproblemIfthelengthistooshortthesecurityisnotsufficientsoanerroroccurs";

// - Method
    @BeforeEach
    void setUp() {
        jwtUtil = new JwtUtil();

        ReflectionTestUtils.setField(jwtUtil, "secretKeyString", SECRET_KEY);
        jwtUtil.init();
    }
    
    @Test
    @DisplayName("JWT 토큰 생성 시 username과 role 정보가 정상적으로 포함이 되었는지 테스트")
    void generateToken_정상케이스_Claims확인() {
        // - givne
        String username = "kim-hwan";
        UserRoleEnum role = UserRoleEnum.ADMIN;

        // - when
        String jwtToken = jwtUtil.generateToken(username, role);
        String jwt = jwtToken.substring(BEARER_PREFIX.length());

        // - then
        // - 1. jwtToken이 Bearer로 시작 하는지 검증
        assertThat(jwtToken).startsWith(BEARER_PREFIX);
        // - 2. jwt가 유효한지 검증
        Claims claims = jwtUtil.getParser()
                .parseSignedClaims(jwt)
                .getPayload();

        assertThat(claims.get("username", String.class)).isEqualTo(username);
        assertThat(claims.get("auth", String.class)).isEqualTo(role.name());
        assertThat(claims.getExpiration()).isAfter(new java.util.Date());
    }
}