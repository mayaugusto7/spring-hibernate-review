package br.com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanProcessorDemoApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach theCoach = context.getBean("NFLCoach", Coach.class);

		Coach alphaCoach = context.getBean("NFLCoach", Coach.class);
		
		boolean result = (theCoach == alphaCoach);
		
		System.out.println("\nPoiting to the same object: " + result);
		
		System.out.println("\nMemory location for theCoach: " + theCoach);

		System.out.println("\nMemory location for alphaCoach: " + alphaCoach + "\n");
		
		context.close();	
	}
}
