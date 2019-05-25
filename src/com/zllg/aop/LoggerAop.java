package com.zllg.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("logger")
@Aspect
public class LoggerAop {
	
	Logger logger=Logger.getLogger(LoggerAop.class);
	
	 //定义切点
    @Pointcut("execution(* com.zllg.service.impl.*.*(..))")
    public void sayings(){}
    
    
    @Before("sayings()")
   	public void logger(JoinPoint joinPoint){
    	 logger.debug("调用了类:" + joinPoint.getTarget());
         logger.debug("调用的方法:" + joinPoint.getSignature().getName()); 
         Object[] obj=joinPoint.getArgs();
         if(obj.length>0){
        	 StringBuffer sb=new StringBuffer();
        	 for(Object ob:obj){
        		 sb.append(ob+"  ");
        	 }
        	 logger.debug("参数为:" +sb); 
         }
         
    }
    
    @AfterReturning(pointcut="sayings()",returning="returnData")
    public void destory(JoinPoint joinPoint,Object returnData){
    	 logger.debug("调用结束"); 
    }
    
}
