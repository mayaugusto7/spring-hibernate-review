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
	
		// call the business method
		Account account = new Account();
		accountDAO.addAccount(account, true);
		accountDAO.doWork();
	
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		membershipDAO.addSillyMember();
		membershipDAO.goToSleep();
		
		context.close();
	}

}
