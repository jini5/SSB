package com.example.bitcointest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value={"com.example.bitcoinTest.mapper"})
public class BitcoinTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(BitcoinTestApplication.class, args);
    }

}
