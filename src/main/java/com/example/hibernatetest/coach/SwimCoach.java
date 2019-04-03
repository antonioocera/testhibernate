package com.example.hibernatetest.coach;

import com.example.hibernatetest.fortune.FortuneService;

public class SwimCoach implements Coach {

    private FortuneService fortuneService;

    public SwimCoach(FortuneService thefortuneService){
        fortuneService = thefortuneService;
    }
    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters as a warm up.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
