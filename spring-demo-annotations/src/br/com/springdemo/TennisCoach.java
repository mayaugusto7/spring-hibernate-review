package br.com.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// @Component("thatSillyCoach")
// @Component default: is tennisCoach 
@Component
//@Scope("prototype")
public class TennisCoach implements Coach {

	private final FortuneService fortuneService;
	
	// Não é obrigatorio quando temos apenas um construtor
	// Quando temos mais de uma implementação da mesma interface, devemos indicar para o spring qual implementação usar @Qualifier
	@Autowired
	public TennisCoach(@Qualifier("happyFortuneService")FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	// define my init method executa antes do constructor
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">> TennisCoach: inside of doMyStartupStuff()");
	}
	
	// define my destroy method executa antes de destruir o bean
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">> TennisCoach: inside of doMyCleanupStuff()");
	}
	
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return this.fortuneService.getFortune();
	}

}
