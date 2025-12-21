package sparta.common.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import sparta.domain.user.service.UserService;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Component
@Slf4j
@RequiredArgsConstructor
public class UserOwnerCheckInterceptor implements HandlerInterceptor {
// - Properties
    private final UserService userService;

// - Methods
    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler)
    throws IOException {
        // - 1. 현재 로그인한 사용자 이름 꺼내기
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = auth.getName();

        // - 2. 요청 URI에서 postId 추출
        String path = request.getRequestURI();  // - /api/user/{username/email
        String decodePath = URLDecoder.decode(path, StandardCharsets.UTF_8);

        String [] parseList = decodePath.split("/");
        String username = parseList[parseList.length - 2];

        // - 3. 작성자와 비교
        if (!currentUsername.equals(username)) {
            log.warn("사용자 불일치, 접근 거부");
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "작성자만 수정할 수 있습니다.");
            return false;
        }

        return true;
    }
}
