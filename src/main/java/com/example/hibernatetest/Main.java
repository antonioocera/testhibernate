package com.example.hibernatetest;

import com.example.hibernatetest.coach.Coach;
import org.springframework.boot.SpringApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@SpringBootApplication
public class Main{

    public static void main(String[] args){
        SpringApplication.run(Main.class, args);

        // leggere file di configurazione di spring, avviare context
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");

        // recuperare il bean dallo spring container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);
        Coach alphaCoach = context.getBean("tennisCoach", Coach.class);

        // verifica se sono uguali
        boolean result = (theCoach == alphaCoach);
        System.out.println("entrambi i Coach puntano allo stesso oggetto: " +result);
        System.out.println("locazione di memoria per theCoach: " + theCoach + "\n");
        System.out.println("locazione di memoria per alphaCoach: " + alphaCoach + "\n");

        // chiudere context
        context.close();

    }
}
