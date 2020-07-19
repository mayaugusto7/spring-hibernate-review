package br.com.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("br.com.springdemo") sem esta anotação precisamos mapear os beans dentro desta classe e a DI
@PropertySource("classpath:sport.properties")
@PropertySource("classpath:logger.properties")
public class SportConfig {
	
	@Bean
	public MyLoggerConfig myLoggerConfig() {
		return new MyLoggerConfig();
	}

	// define bean for our sad fortune service
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	// define bean for our swin coach and inject depedency
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
}
