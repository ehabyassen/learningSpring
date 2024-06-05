package com.luv2code.springcoredemo.controllers;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {

    private Coach coach1;
    private Coach coach2;

    @Autowired
    public CoachController(@Qualifier("cricketCoach") Coach coach1,
                           @Qualifier("cricketCoach") Coach coach2) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        this.coach1 = coach1;
        this.coach2 = coach2;
        //A bean in Spring is singleton by default. So, oly one bean is initialized once and can be injected many times.
        System.out.println("Do coach 1 and coach 2 point to the same instance? " + coach1.equals(coach2));
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return coach1.getDailyWorkout();
    }
}
