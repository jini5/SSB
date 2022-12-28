package com.example.demoxenium;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value={"com.example.demoxenium.mapper"})
public class DemoXeniumApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoXeniumApplication.class, args);
    }

}
