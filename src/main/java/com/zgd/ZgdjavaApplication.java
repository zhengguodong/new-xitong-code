package com.zgd;

import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages="com.zgd.mapper")
@SpringBootApplication

public class ZgdjavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZgdjavaApplication.class, args);
    }

}
