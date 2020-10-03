package br.com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressionsShare {

	@Pointcut("execution(* br.com.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	// create pointcut for getter method
	@Pointcut("execution(* br.com.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	// create pointcut for setter method
	@Pointcut("execution(* br.com.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	// create pointcut: include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}
	
}
