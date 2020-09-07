package br.com.aopdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("br.com.aopdemo")
@PropertySource("classpath:logger.properties")
public class DemoConfig {
	
	@Bean
	public MyLoggerConfig myLoggerConfig() {
		return new MyLoggerConfig();
	}

}
