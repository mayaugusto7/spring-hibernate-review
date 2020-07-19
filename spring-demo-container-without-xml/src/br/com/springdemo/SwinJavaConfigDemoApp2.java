package br.com.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwinJavaConfigDemoApp2 {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		Coach tennis = context.getBean("tennisCoach", Coach.class);
		
		System.out.println(tennis.getDailyWorkout());
		
		System.out.println(tennis.getDailyFortune());
				
		context.close();
	}

}
