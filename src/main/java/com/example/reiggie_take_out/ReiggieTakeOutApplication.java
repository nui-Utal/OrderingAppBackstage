package com.example.reiggie_take_out;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages="com.example.reiggie_take_out.controller")
@ComponentScan(basePackages = {"com.example.reiggie_take_out.entity"})
public class ReiggieTakeOutApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReiggieTakeOutApplication.class, args);
    }

}
