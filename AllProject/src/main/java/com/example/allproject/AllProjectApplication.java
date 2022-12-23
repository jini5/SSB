package com.example.allproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value={"com.example.allproject.mapper"})
public class AllProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(AllProjectApplication.class, args);
    }

}
