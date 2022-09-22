package com.revature.project2;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication // implies @Configuration @ComponentScan and @AutoConfiguration
public class Project2 {

    public static void main(String[] args) {
        SpringApplication.run(Project2.class, args);
    }

    @Bean
    public ObjectMapper jsonMapper() {
        return new ObjectMapper();
    }

}
