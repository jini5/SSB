package com.example.bitcoinadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value={"com.example.bitcoinadmin.mapper"})
public class BitCoinAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(BitCoinAdminApplication.class, args);
    }

}
