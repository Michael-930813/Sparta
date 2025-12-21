package sparta.scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringWebSchedulerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebSchedulerApplication.class, args);
    }

}
