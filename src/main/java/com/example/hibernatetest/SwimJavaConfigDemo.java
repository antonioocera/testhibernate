package com.example.hibernatetest;

import com.example.hibernatetest.coach.Coach;
import com.example.hibernatetest.coach.SportConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SwimJavaConfigDemo extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SwimJavaConfigDemo.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SwimJavaConfigDemo.class, args);

		// leggere classe java di configurazione, avviare context
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

		// recuperare il bean dallo spring container
		Coach theCoach = context.getBean("swimCoach", Coach.class);

		// chiamare un metodo dal bean
		System.out.println(theCoach.getDailyWorkout());

		// chiamare un metodo per la fortuna
		System.out.println(theCoach.getDailyFortune());

		// chiudere context
		context.close();
	}
}
