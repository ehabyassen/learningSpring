package com.luv2code.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//to scan components out of the default base package com.luv2code.spring
//@SpringBootApplication(scanBasePackages = {"com.luv2code.springcoredemo", "com.luv2code.util"})
@SpringBootApplication
public class SpringCoreDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCoreDemoApplication.class, args);
    }
}
