package br.com.springdemo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class NFLCoach implements Coach, DisposableBean {

	private FortuneService fortuneService;
	
	public NFLCoach() {
		System.out.println(">> NFLCoach: inside default constructor");
	}
	
	@PostConstruct
	public void afterConstructorCall() {
		System.out.println(">> NFLCoach: inside afterConstructorCall()");
	}
	
	@Autowired
	@Qualifier("happyFortuneService")
	public void doSomeCrazyStuff(FortuneService fortuneService) {
		System.out.println(">> NFLCoach: inside doSomeCrazyStuff");
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "The NFL has 4 time of 12 minutes";
	}

	@Override
	public String getDailyFortune() {
		return this.fortuneService.getFortune();
	}

	@Override
	public void destroy() throws Exception {
		System.out.println(">> NFLCoach: inside destroy() DisposableBean interface");
	}

}
