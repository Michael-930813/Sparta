package sparta.common.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Order(1)
public class NbcamFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // - 요청이 들어갈 때 실행되는 부분
        //System.out.println("NbcamFilter로 들어간다");

        // - 필터 계속 진행
        filterChain.doFilter(request, response);

        // - 요청이 나갈 때 실행되는 부분
        //System.out.println("NbcamFilter로 나간다");
    }
}
