package org.example.springweb_basic;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 요청 정보는 필요없으므로 요청 정보를 꺼내지는 않습니다.
        // 비즈니스 로직 또한 따로 없으므로 작성하지 않습니다.
        resp.setContentType("text/plain; charset=UTF-8"); // 응답 정보 타입 설정
        resp.getWriter().print("hello spring!"); // Response 객체에 응답 정보인 'hello'를 담아줍니다.
    }
}