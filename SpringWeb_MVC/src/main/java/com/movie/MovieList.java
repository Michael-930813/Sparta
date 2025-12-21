package com.movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieList {
    private static final List<Movie> movies = new ArrayList<>(Arrays.asList(
        new Movie("부산행", "https://github.com/user-attachments/assets/485f5998-34e6-4060-80fe-6789a9dddd7e"),
        new Movie("백두산", "https://github.com/user-attachments/assets/b062e53c-7868-4e13-9c0d-98cc37b5bd31"),
        new Movie("파묘", "https://github.com/user-attachments/assets/b5962a1a-e962-4bd1-9164-a8aad9af290b"),
        new Movie("극한직업", "https://github.com/user-attachments/assets/5855f5fb-0767-4c87-91bc-3515feb4fbdb"),
        new Movie("괴물", "https://github.com/user-attachments/assets/2cd478af-d0c8-4e00-9186-1259bc43e3b5")
    ));
    
    public static List<Movie> getAll() {
        return new ArrayList<>(movies);
    }
    
    public static void add(Movie movie) {
        movies.add(movie);
    }
    
    public static void removeByTitle(String title) {
        movies.removeIf(m -> m.getTitle().equals(title));
    }
}