package br.com.springdemo;

public class SoccerCoach implements Coach {

	private FortuneService fortuneService;
	
	public SoccerCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "The best soccer coach is Pepe Guardiola";
	}

	@Override
	public String getDailyFortune() {
		return this.fortuneService.getFortune();
	}

}
