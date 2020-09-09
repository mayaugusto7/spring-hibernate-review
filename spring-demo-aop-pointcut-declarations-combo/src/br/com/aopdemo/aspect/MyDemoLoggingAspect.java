package br.com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	@Pointcut("execution(* br.com.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	// create pointcut for getter method
	@Pointcut("execution(* br.com.aopdemo.dao.*.get*(..))")
	private void getter() {}
	
	// create pointcut for setter method
	@Pointcut("execution(* br.com.aopdemo.dao.*.set*(..))")
	private void setter() {}
	
	// create pointcut: include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n======>>> Executing @Before advice on method");
	}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("\n======>>> Executing API Analitycs");
	}
}
