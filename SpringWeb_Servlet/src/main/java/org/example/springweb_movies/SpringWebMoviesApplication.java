package org.example.springweb_movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class SpringWebMoviesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebMoviesApplication.class, args);
    }

}
