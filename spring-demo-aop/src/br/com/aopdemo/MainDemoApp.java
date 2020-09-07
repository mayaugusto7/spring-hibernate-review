package br.com.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.aopdemo.dao.AccountDAO;
import br.com.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		// call the business method
		accountDAO.addAccount();
		membershipDAO.addSillyMember();
		
		// do it againg!
		// System.out.println("\n let's call it again!\n");
		
		// call the business again
		// accountDAO.addAccount();
		
		// close the context
		context.close();
	}

}
