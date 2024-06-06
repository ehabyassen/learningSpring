package com.luv2code.springcoredemo.config;

import com.luv2code.springcoredemo.common.Coach;
import com.luv2code.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    //can be used with a 3rd party class to make it a Spring Bean
    @Bean("aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
