package br.com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach tennis = context.getBean("tennisCoach", Coach.class);
		System.out.println("Tennis...");
		System.out.println(tennis.getDailyWorkout());
		System.out.println(tennis.getDailyFortune());
		
		System.out.println();
		
		Coach soccer = context.getBean("soccerCoach", Coach.class);
		System.out.println("Soccer...");
		System.out.println(soccer.getDailyWorkout());
		System.out.println(soccer.getDailyFortune());

		System.out.println();
		
		Coach basket = context.getBean("basketCoach", Coach.class);
		System.out.println("Basketball...");
		System.out.println(basket.getDailyWorkout());
		System.out.println(basket.getDailyFortune());
	
		System.out.println();
		
		Coach nfl = context.getBean("NFLCoach", Coach.class);
		System.out.println("NFLCoach...");
		System.out.println(nfl.getDailyWorkout());
		System.out.println(nfl.getDailyFortune());

		System.out.println();
		
		Coach baseball = context.getBean("baseballCoach", Coach.class);
		System.out.println("BaseballCoach...");
		System.out.println(baseball.getDailyWorkout());
		System.out.println(baseball.getDailyFortune());

		System.out.println();
		
		SwimCoach swim = context.getBean("swimCoach", SwimCoach.class);
		System.out.println("SwimCoach...");
		System.out.println(swim.getDailyWorkout());
		System.out.println(swim.getEmail());
		System.out.println(swim.getTeam());
		
		context.close();
	}

}
