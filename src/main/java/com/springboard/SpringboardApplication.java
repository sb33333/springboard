package com.springboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("database.properties")
public class SpringboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringboardApplication.class, args);
    }

}
