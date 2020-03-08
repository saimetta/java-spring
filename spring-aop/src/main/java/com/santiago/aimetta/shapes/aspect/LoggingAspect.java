package com.santiago.aimetta.shapes.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	

	@Before("execution(public String com.santiago.aimetta.shapes.Circle.getName())")
	public void loggingCircleGetNameAdvice() {
		System.out.println("getName was called");
	}
	
	@Before("execution(public *  com.santiago.aimetta.shapes.*.get*())")
	public void loggingGetAdvice() {
		System.out.println("a get was called");
	}
	
	@Pointcut("execution(public void com.santiago.aimetta.shapes.Circle.set*(..))")
	public void allSetters() {}
	
	@Before("allSetters()")
	public void loggingSetAdvice() {
		System.out.println("a set was called");
	}
	//Just showing how to re use pointcuts
	@Before("allSetters()")
	public void loggingSetTwoAdvice() {
		System.out.println("a set(2) was called");
	}
	
	@Pointcut("within(com.santiago.aimetta.shapes.Triangle)")
	public void allTriangleMethods() {}
	
	@Pointcut("args(name)")
	public void stringArgs(String name) {}
	
	@Before("allTriangleMethods() && allSetters()")
	public void loggingThirdAdvice(JoinPoint joinPoint) {
		System.out.println(joinPoint.toString());
		System.out.println("Thrid advice!!!");
	}
	
	@Before("allTriangleMethods() && stringArgs(name)")
	public void loggingMethodsWithStringParameterAdvice(String name) {
		System.out.println("Method with string parameter in triangle. Value: "+name);
	}
	
	
	/**
	 * Other useful types
	 * @After
	 * @AfterReturning will execute when the method successfully returns, if an exception is thrown will be ignored
	 * @AfterThrowing will execute when an exception is thrown
	 */
	
	@AfterReturning(pointcut = "allTriangleMethods() && stringArgs(name)", returning = "returnValue")
	public void loggingMethodAfterReturningAdvice(String name, String returnValue) {
		System.out.println("Loggin on return input: "+name+" returnValue: "+returnValue);
	}
	
	@AfterThrowing(pointcut = "allTriangleMethods()", throwing = "exception")
	public void loggingExceptionAdvice(RuntimeException exception) {
		System.out.println("A method returned this exception :"+exception.getMessage());
	}
	
	//This executes as an before and after combined
	@Around("allTriangleMethods()")
	public Object loggingAfterAndBeforeAllMethods(ProceedingJoinPoint joinPoint) {
		Object result = null;
		try {
			System.out.println("Before advice: "+joinPoint.toString());
			result = joinPoint.proceed();
			System.out.println("After returning: "+joinPoint.toString());
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("After throwing: "+joinPoint.toString());
		}
		System.out.println("Finally : "+joinPoint.toString());
		return result;
	}
	
	@Around("@annotation(com.santiago.aimetta.shapes.aspect.Loggable)")
	public Object loggingAroundAdvice(ProceedingJoinPoint joinPoint) {
		Object result = null;
		try {
			System.out.println("[Loggable] Before advice: "+joinPoint.toString());
			result = joinPoint.proceed();
			System.out.println("[Loggable] After returning: "+joinPoint.toString());
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("[Loggable] After throwing: "+joinPoint.toString());
		}
		System.out.println("[Loggable] Finally : "+joinPoint.toString());
		return result;
	}
}
