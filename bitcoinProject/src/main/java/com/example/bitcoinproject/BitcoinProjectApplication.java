package com.example.bitcoinproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value={"com.example.bitcoinproject.mapper"})
public class BitcoinProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(BitcoinProjectApplication.class, args);
    }

}
