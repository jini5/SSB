package com.example.demoweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value={"com.example.demoweb.mapper"})
public class DemowebApplication {


    public static void main(String[] args) {
        SpringApplication.run(DemowebApplication.class, args);
    }

}
