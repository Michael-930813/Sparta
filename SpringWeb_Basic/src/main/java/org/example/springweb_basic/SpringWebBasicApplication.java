package org.example.springweb_basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class SpringWebBasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebBasicApplication.class, args);
    }

}
