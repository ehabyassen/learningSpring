package com.luv2code.springcoredemo.controllers;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {

    private Coach coach;

    @Autowired
    //@Qualifier overwrites @Primary
    //it is recommended to use @Qualifier because:
    //1- it is more specific
    //2- it has higher priority
    //public CoachController(@Qualifier("cricketCoach") Coach coach) {
    public CoachController( Coach coach) {
        this.coach = coach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return coach.getDailyWorkout();
    }
}
