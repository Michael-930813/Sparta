package org.example.plus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlusApplication.class, args);
    }

}
