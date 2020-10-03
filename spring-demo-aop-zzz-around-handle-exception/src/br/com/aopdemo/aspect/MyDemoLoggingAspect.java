package br.com.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Around("execution(* br.com.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		// print out method we are advising on
		String method = proceedingJoinPoint.getSignature().toShortString();
		logger.info("\n======>>> Executing @Around on method: " + method);
		
		// get begin timestamp
		long begin = System.currentTimeMillis();
		
		// now, let's excute the method
		Object result = null; 
				
		try {
			result = proceedingJoinPoint.proceed();
		} catch (Exception e) {
			logger.warning(e.getMessage());
			//result = "Major accident! New problem found";
			
			// rethrow exception
			throw e;
		}
		
		// get end timestamp
		long end = System.currentTimeMillis();
		
		// compute duration
		long duration = end - begin;
		logger.info("\n======> Duration: " + duration / 1000.0 + " seconds");
		
		return result;
	}
	
	@After("execution(* br.com.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
		
		String method = joinPoint.getSignature().toShortString();
		logger.info("\n======>>> Executing @After (finally) on method: " + method);
	}
	
	@AfterThrowing(
			pointcut = "execution(* br.com.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing = "theExc"
			)
	public void afterThrowingFindAccountAdvice(JoinPoint joinPoint, Throwable theExc) {
		
		String method = joinPoint.getSignature().toShortString();
		logger.info("\n======>>> Executing @AfterThrowing on method: " + method);
		
		logger.info("\n======>>> The exception is: " + theExc);
	}
	
	// add a new adivce for @AfterReturning on the findAccounts method
	@AfterReturning(
				pointcut = "execution(* br.com.aopdemo.dao.AccountDAO.findAccounts(..))",
				returning = "result"
			)
	public void afterReturningFindAccountsAdivice(JoinPoint joinPoint, List<Account> result) {
		
		String method = joinPoint.getSignature().toShortString();
		logger.info("\n======>>> Executing @AfterReturning on method: " + method);
	
		logger.info("\n======>>> result is: " + result);
		
		// post-process the data ... let's modify it :-)
		
		convertAccountNamesToUpperCase(result);
	
		logger.info("\n======>>> result is: " + result);
	}
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		for (Account account : result) {
			String nameUpperCase = account.getName().toUpperCase();
			account.setName(nameUpperCase);
		}
	}

	@Before("br.com.aopdemo.aspect.AopExpressionsShare.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		
		logger.info("\n======>>> Executing @Before advice on method");
	
		// display the method signature
		Signature methodSignature = joinPoint.getSignature();
		
		logger.info("Method: " + methodSignature);
		
		// display the method arguments
		Object[] args = joinPoint.getArgs();
		
		for (Object tempArg : args) {
			logger.info(tempArg.toString());
			
			if (tempArg instanceof Account) {
				Account theAccount = (Account) tempArg;
				logger.info("account name: " + theAccount.getName());
				logger.info("account level: " + theAccount.getLevel());
			}
		}
	}	
}
