package com.luv2code.springcoredemo.controllers;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {

    private Coach coach;

    //bean id is the same as class name but starts with a lower case character
    @Autowired
    public CoachController(@Qualifier("trackCoach") Coach coach) {
        this.coach = coach;
    }

    //can be done also with setter injection
    //@Autowired
    public void setCoach(@Qualifier("tennisCoach") Coach coach) {
        this.coach = coach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return coach.getDailyWorkout();
    }
}
