package org.sparta.scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringWebHomeworkSchedulerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebHomeworkSchedulerApplication.class, args);
    }

}