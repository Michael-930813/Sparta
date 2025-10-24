package org.example.plus.common.filter;

import static org.example.plus.common.utils.JwtUtil.BEARER_PREFIX;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.plus.common.enums.UserRoleEnum;
import org.example.plus.common.utils.JwtUtil;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {


        // JWT 토큰이 있는지 없는지 검사
        // 로그인 url은 제외하고 다른 url은 모두 토큰이 있어야만 접근 가능

        String requestUrl = request.getRequestURI();

        if(requestUrl.equals("/api/login")) {
            filterChain.doFilter(request,response);
            return;
        }

        String authorizationHeader = request.getHeader("Authorization");

        // 토큰이 있는지 없는지 검사하는 과정
        if (authorizationHeader == null || !authorizationHeader.startsWith(BEARER_PREFIX)) {
            // 토큰이 없을 때 실행
            log.info("JWT 토큰이 필요합니다.");
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "JWT 토큰이 필요해");
            return;
        }

        // 토큰이 있을 때 실행하는 과정
        // 그 토큰이 유효한지 유효하지 않은지 이것도 검사해줘야겠죠?

        String jwt = authorizationHeader.substring(7);

        // 토큰의 유효성 검사
        if (!jwtUtil.validateToken(jwt)) {
            // 유효하지 않은 경우
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write("{\"error\": \"Unauthorized\"}");
        }



        // 토큰이 유효한 경우에 여기서 실행이 되겠죠?

        String username = jwtUtil.extractUsername(jwt);

        String auth = jwtUtil.extractRole(jwt);

        UserRoleEnum userRoleEnum = UserRoleEnum.valueOf(auth);

        // JWT 토큰에서 복호화 한 데이터 저장하기

        // request.setAttribute("username", username); -> Spring Security 방식에 맞는 방법으로 만들어줄것임.

        // Spring Security에서 사용하는 User 객체를 생성했습니다.
        User user = new User(username, "", List.of(userRoleEnum::getRole));

        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user, null , user.getAuthorities()));

        //log.info(" 1번 : JwtFilter 인증/인가 성공 -> 다음 담계로 넘어감.");

        filterChain.doFilter(request, response);

        //log.info(" 8번째 : JwtFilter 통과 완료 후 postman에 전달 끝");


    }
}
