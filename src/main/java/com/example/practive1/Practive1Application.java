package com.example.practive1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@ComponentScans("com.example.practive1.repo")
@EntityScan("com.example.practive1.entity")
@EnableJpaRepositories("com.example.practive1.repository")
public class Practive1Application {

    public static void main(String[] args) {
        SpringApplication.run(Practive1Application.class, args);
    }

}
