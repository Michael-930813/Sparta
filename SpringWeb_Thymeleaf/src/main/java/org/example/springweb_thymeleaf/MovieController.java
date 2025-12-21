package org.example.springweb_thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Random;

@Controller
public class MovieController {

    @GetMapping("/movies")
    public String getMovieRecommendation(Model model) {
        String recommendedMovie = getMovieRecommendation();

        model.addAttribute("title", "🎬 영화 추천 결과");
        model.addAttribute("recommendedMovie", recommendedMovie);
        model.addAttribute("totalMovies", recommendedMovies.size());
        model.addAttribute("allMovies", recommendedMovies);

        return "movies";  // templates/movies.html 로 매핑
    }

    private final List<String> recommendedMovies = List.of(
            "쇼생크 탈출",
            "대부",
            "다크 나이트",
            "인생은 아름다워",
            "기생충",
            "타이타닉",
            "아바타",
            "어벤져스: 엔드게임"
    );

    private final Random random = new Random();

    private String getMovieRecommendation() {
        int randomIndex = random.nextInt(recommendedMovies.size());
        return recommendedMovies.get(randomIndex);
    }
}
