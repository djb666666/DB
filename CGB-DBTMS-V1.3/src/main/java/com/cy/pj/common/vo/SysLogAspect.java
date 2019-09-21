package com.cy.pj.common.vo;

import java.lang.reflect.Method;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.cy.pj.sys.dao.SysLogDao;
import com.cy.pj.sys.entity.SysLog;
import com.fasterxml.jackson.core.JsonProcessingException;

public class SysLogAspect {
	private Logger log=Logger.getLogger(SysLogAspect.class);
	@Autowired
	private SysLogDao sysLogDao;
	@Pointcut("@annotation(com.cy.pj.commom.anno.RequestLog)")
	public void logPointCut() {}
	@Around("logPointCut()")
	public Object around(ProceedingJoinPoint jp) throws Throwable {
		long starttime=System.currentTimeMillis();
		Object result = jp.proceed();
		long endtime=System.currentTimeMillis();
		long totaltime=endtime-starttime;
		saveSysLog(jp,totaltime);
		return result;
	}
	private void saveSysLog(ProceedingJoinPoint jp, long totaltime)
			throws NoSuchMethodException,SecurityException,JsonProcessingException {
		//1.获取日志信息
		MethodSignature ms = (MethodSignature) jp.getSignature();
		Class<?> targetClass = jp.getTarget().getClass();
		String ClassName = targetClass.getName();
		//获取接口声明的方法
		String methodName = ms.getMethod().getName();
		Class<?>[] parameterTypes = ms.getMethod().getParameterTypes();
		//获取目标对象方法
		Method targetMethod = targetClass.getDeclaredMethod(methodName, parameterTypes);
		//2.封装日志信息
		SysLog log=new SysLog();
		log.setCreatedTime(new Date());
		//log.setIp(IPUtils.getIpAddr());
		log.setMethod(ClassName+"."+methodName);
		log.setOperation("operation");
		log.setParams("");
		log.setTime(totaltime);
		log.setUsername("");
		log.setId(1);
		//3.保存日志信息
		sysLogDao.insertObject(log);
	}
}
