package com.example.hibernatetest.coach;

import com.example.hibernatetest.fortune.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("singleton")
public class TennisCoach implements Coach {

    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    // definisci un costruttore default
    public TennisCoach(){
        System.out.println("Sono dentro il costruttore default");
    }

    // definisci un metodo di inizializzazione bean
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("dentro Startup");
    }

    // definisci un metodo di distruzione bean
    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println("dentro Cleanup");
    }

    /*
    // definisci un metodo setter (setter injection)
    @Autowired
    public void setFortuneService(FortuneService theFortuneService){
        System.out.println("Dentro il metodo setter");
        fortuneService = theFortuneService;
    }

    // method injection (un metodo qualunque)
    @Autowired
    public void doSomeCrazyStuff(FortuneService theFortuneService){
        System.out.println("Dentro il metodo crazy");
        fortuneService = theFortuneService;
    }

    // constructor injection
    @Autowired
    public TennisCoach(FortuneService theFortuneService) {
        fortuneService = theFortuneService;
    }
     */


    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
