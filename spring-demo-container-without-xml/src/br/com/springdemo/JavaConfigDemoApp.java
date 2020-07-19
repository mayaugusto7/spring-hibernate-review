package br.com.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		SwimCoach swim = context.getBean("swimCoach", SwimCoach.class);
		
		System.out.println(swim.getDailyWorkout());
		
		System.out.println(swim.getDailyFortune());
		
		// call new methods
		System.out.println("email: " + swim.getEmail());

		System.out.println("team: " +swim.getTeam());
				
		context.close();
	}

}
