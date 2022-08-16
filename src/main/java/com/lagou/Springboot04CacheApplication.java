package com.lagou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.lagou.mapper")
@EnableCaching
public class Springboot04CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot04CacheApplication.class, args);
    }

}
