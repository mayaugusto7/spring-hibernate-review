package br.com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScopeApplicationContext.xml");
	
		// retrieve bean from spring container
		Coach theCoath = context.getBean("myCoach", Coach.class);

		Coach alphaCoath = context.getBean("myCoach", Coach.class);
		
		// check if they same reference object theCoath and alphaCoath
		boolean result = (theCoath == alphaCoath);
		
		// print out the results
		System.out.println("\nPointing to the same object: " + result);
		
		System.out.println("\nMemory location for theCoach: " + theCoath);

		System.out.println("\nMemory location for alphaCoach: " + alphaCoath + "\n");
		
		// close context
		context.close();
	}

}
