package com.zsq.testmybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zsq.testmybatisplus.mapper")
public class TestmybatisplusApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestmybatisplusApplication.class, args);
    }

}
