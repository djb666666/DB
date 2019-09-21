package com.cy.pj.common.vo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class OtherAspect {
	@Around("within(com.cy.pj.sys.service..*)")
	//@Around("execution(* com.cy.pj.sys.service.. )")
	//@Around("@annotation(com.cy.pj.common.annotation.RequiredLog)")
	public Object around(ProceedingJoinPoint jp) throws Throwable{
		Object result = jp.proceed();
		return result;
	}
}
