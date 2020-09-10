package br.com.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.aopdemo.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	// add a new adivce for @AfterReturning on the findAccounts method
	@AfterReturning(
				pointcut = "execution(* br.com.aopdemo.dao.AccountDAO.findAccounts(..))",
				returning = "result"
			)
	public void afterReturningFindAccountsAdivice(JoinPoint joinPoint, List<Account> result) {
		
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n======>>> Executing @AfterReturning on method: " + method);
	
		System.out.println("\n======>>> result is: " + result);
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
