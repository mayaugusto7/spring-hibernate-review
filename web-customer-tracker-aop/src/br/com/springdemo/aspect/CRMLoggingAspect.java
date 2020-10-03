package br.com.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	// setup logger
	private Logger logger = Logger.getLogger(getClass().getName());
	
	// add pointcuts
	@Pointcut("execution(* br.com.springdemo.controller.*.*(..))")
	private void forControllerPackage() { }
	
	@Pointcut("execution(* br.com.springdemo.service.*.*(..))")
	private void forServicePackage() { }
	
	@Pointcut("execution(* br.com.springdemo.dao.*.*(..))")
	private void forDaoPackage() { }
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() { }
	
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {
		
		String method = joinPoint.getSignature().toShortString();
		logger.info("=====> in @Before calling method: " + method);
		
		Object[] args = joinPoint.getArgs();
		
		for (Object arg : args) {
			logger.info("=======>> argument:" + arg);
		}
	}
	
	
	@AfterReturning( pointcut = "forAppFlow()",
					 returning = "theResult")
	public void afterReturning(JoinPoint joinPoint, Object theResult) {
		
		String method = joinPoint.getSignature().toShortString();
		logger.info("=====> in @AfterReturning: from method: " + method);
		
		logger.info("=====> result: " + theResult);
	}
	
}
