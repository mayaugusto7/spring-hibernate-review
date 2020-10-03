package br.com.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.aopdemo.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	@AfterThrowing(
			pointcut = "execution(* br.com.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing = "theExc"
			)
	public void afterThrowingFindAccountAdvice(JoinPoint joinPoint, Throwable theExc) {
		
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n======>>> Executing @AfterThrowing on method: " + method);
		
		System.out.println("\n======>>> The exception is: " + theExc);
	}
	
	// add a new adivce for @AfterReturning on the findAccounts method
	@AfterReturning(
				pointcut = "execution(* br.com.aopdemo.dao.AccountDAO.findAccounts(..))",
				returning = "result"
			)
	public void afterReturningFindAccountsAdivice(JoinPoint joinPoint, List<Account> result) {
		
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n======>>> Executing @AfterReturning on method: " + method);
	
		System.out.println("\n======>>> result is: " + result);
		
		// post-process the data ... let's modify it :-)
		
		convertAccountNamesToUpperCase(result);
	
		System.out.println("\n======>>> result is: " + result);
	}
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		for (Account account : result) {
			String nameUpperCase = account.getName().toUpperCase();
			account.setName(nameUpperCase);
		}
	}

	@Before("br.com.aopdemo.aspect.AopExpressionsShare.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		
		System.out.println("\n======>>> Executing @Before advice on method");
	
		// display the method signature
		Signature methodSignature = joinPoint.getSignature();
		
		System.out.println("Method: " + methodSignature);
		
		// display the method arguments
		Object[] args = joinPoint.getArgs();
		
		for (Object tempArg : args) {
			System.out.println(tempArg);
			
			if (tempArg instanceof Account) {
				Account theAccount = (Account) tempArg;
				System.out.println("account name: " + theAccount.getName());
				System.out.println("account level: " + theAccount.getLevel());
			}
		}
	}	
}
