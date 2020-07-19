package br.com.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {

	// dependency injection field
	@Autowired
	@Qualifier("happyFortuneService")
	private FortuneService fortuneService;
	
	public BaseballCoach() {
		System.out.println(">> BasketCoach: inside default constructor");
	}
	
	@Override
	public String getDailyWorkout() {
		return "Baseball is bored";
	}

	@Override
	public String getDailyFortune() {
		return this.fortuneService.getFortune();
	}

}
