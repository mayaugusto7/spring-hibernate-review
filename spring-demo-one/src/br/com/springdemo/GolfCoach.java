package br.com.springdemo;

public class GolfCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public GolfCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice your putting skills for 2 hours today";
	}

	@Override
	public String getDailyFortune() {
		return this.fortuneService.getFortune();
	}

}
