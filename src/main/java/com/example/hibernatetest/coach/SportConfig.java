package com.example.hibernatetest.coach;

import com.example.hibernatetest.coach.Coach;
import com.example.hibernatetest.coach.SwimCoach;
import com.example.hibernatetest.fortune.FortuneService;
import com.example.hibernatetest.fortune.SadFortuneService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("com.example.hibernatetest")
public class SportConfig {

    // definire bean per sadFortuneService
    @Bean
    public FortuneService sadFortuneService(){
        return new SadFortuneService();
    }

    // definire bean per SwimCoach e dependency injection
    @Bean
    public Coach swimCoach(){
        return new SwimCoach(sadFortuneService());
    }
}
