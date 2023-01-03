package com.cafe.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value={"com.cafe.admin.mapper"})
public class CafeadminApplication {

    public static void main(String[] args) {
        SpringApplication.run(CafeadminApplication.class, args);
    }

}
