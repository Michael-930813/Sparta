package sparta.scheduler.common.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class LoginCheckFilter extends OncePerRequestFilter {
// - Properties
    // - WhiteList
    private static final String[] WHITELIST = {
        "/users/login",
        "/",
        "/error"
    };


// - Methods
    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain
    ) throws ServletException, IOException {
        // - Get RequestURI
        String requestURI = request.getRequestURI();
        // - Ignore WhiteList
        if (isWhitelisted(requestURI)) {
            chain.doFilter(request, response);
            return;
        }
        // - Check Session
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("userId") == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write("{\"message\":\"로그인이필요합니다.\"}");
            return;
        }

        // - If login, next filter
        chain.doFilter(request, response);
    }

    private boolean isWhitelisted(String requestURI) {
        for (String white : WHITELIST) {
            if (requestURI.equals(white) || requestURI.startsWith(white)) {
                return true;
            }
        }
        return false;
    }
}
