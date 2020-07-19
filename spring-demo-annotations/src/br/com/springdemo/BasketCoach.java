package br.com.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BasketCoach implements Coach {

	private FortuneService fortuneService;
	
	public BasketCoach() {
		System.out.println(">> BasketCoach: inside default constructor");
	}
	
	// set method injection
	@Autowired
	@Qualifier("happyFortuneService")
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println(">> BasketCoach: inside setFortuneService");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "The basketball has 4 times of 15 minutes.";
	}

	@Override
	public String getDailyFortune() {
		return this.fortuneService.getFortune();
	}

}
