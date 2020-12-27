package com.min.edu.aop;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerDaoExecution {
	
	public void before(JoinPoint j) {
		Logger logger = LoggerFactory.getLogger(j.getTarget()+"");
		logger.info("메소드 실행 전");
		
		Object [] args=j.getArgs();
		
		if(args !=null) {
			logger.info("method  시작: \t {}",j.getSignature().getName());
			int cnt=0;
			for(Object obj : args) {
				logger.info((cnt++)+"번째 : \t"+String.valueOf(obj));
			}
			logger.info("-----------------------------");
		}
		
	}
	
	public void afterReturning(JoinPoint j) {
		Logger logger = LoggerFactory.getLogger(j.getTarget()+"");
		logger.info("종료 : \t{}",j.getSignature().getName());
	}
	
	public void afterThrowing(JoinPoint j) {
		Logger logger = LoggerFactory.getLogger(j.getTarget()+""+j.getKind());
		logger.info("에러 발생 : \t{}",j.getArgs());
		logger.info("에러 발생 : \t{}",j.toString());
		
	}
}
