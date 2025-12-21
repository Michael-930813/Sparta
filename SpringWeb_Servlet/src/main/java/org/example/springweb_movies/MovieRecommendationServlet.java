package org.example.springweb_movies;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/movies/recommendation")
public class MovieRecommendationServlet extends HttpServlet {

    private final List<String> recommendedMovies = List.of(
            "쇼생크 탈출",
            "대부",
            "다크 나이트",
            "인생은 아름다워"
    );

    // 1. Map을 JSON으로 바꾸기 위해 필요한 ObjectMapper를 생성합니다.
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // 2. 랜덤으로 영화 하나를 선택합니다.
        int randomIndex = (int) (Math.random() * recommendedMovies.size());
        String randomMovie = recommendedMovies.get(randomIndex);
        Map<String, String> movieMap = Map.of("title", randomMovie);

        // 3. 응답 속성을 설정합니다.
        response.setContentType("application/json; charset=UTF-8");

        // 4. ObjectMapper를 사용해 JSON 문자열로 변환합니다.
        String json = objectMapper.writeValueAsString(movieMap);

        // 5. 생성된 JSON을 클라이언트에게 응답으로 보냅니다.
        response.getWriter().print(json);
    }
}