package sparta.common.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import sparta.common.enums.UserRoleEnum;
import sparta.common.utils.JwtUtil;

import java.io.IOException;
import java.util.List;

import static sparta.common.utils.JwtUtil.BEARER_PREFIX;

@Order(3)
@Component
@Slf4j
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal (
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain )
        throws ServletException, IOException {

        // - JWT 토큰 보유 검사
        String requestURI = request.getRequestURI();

        // - 로그인 시에는 토큰 검사 X
        if(requestURI.equals("/api/login")){
            filterChain.doFilter(request,response);
            return;
        }

        // - JWT 토큰 검증
        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader == null || !authorizationHeader.startsWith(BEARER_PREFIX)) {
            log.info("JWT 토큰이 필요합니다.");
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "JWT 토큰이 필요 합니다.");
            return;
        }

        String jwt = authorizationHeader.substring(7);

        // - 토큰 유효성 검사
        if (!jwtUtil.validateToken(jwt)) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write("{\"error\": \"Unauthorized\"}");
        }


        // - JWT 토큰 데이터 복호화 후 저장
        String username = jwtUtil.extractUsername(jwt);
        String auth = jwtUtil.extractRole(jwt);
        UserRoleEnum userRole = UserRoleEnum.valueOf(auth);

        // - request.setAttribute("username", username); -> Spring Security 방식으로 변경
        // - Spring Security에서 사용하는 User객체 생성
        User user = new User(username, "", List.of(userRole::getRole));

        // - SecurityContextHolder에 저장
        SecurityContextHolder.getContext()
                             .setAuthentication(
                                     new UsernamePasswordAuthenticationToken(
                                             user, null, user.getAuthorities()));

        filterChain.doFilter(request,response);
    }
}
