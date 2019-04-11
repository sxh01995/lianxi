package com.lianxi.utill;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerProxy {
    Logger logger=Logger.getLogger(LoggerProxy.class);
    @Around("execution(public * com.lianxi.service.*.Imp.*.*(..))")
    public Object logging(ProceedingJoinPoint joinPoint){
        System.out.println("------------------->>>");
        try {
            String kind = joinPoint.getKind();
            Object[] args = joinPoint.getArgs();
            logger.debug(kind+":"+args);
            Object proceed = joinPoint.proceed();
            logger.debug("返回值"+proceed);
            return proceed;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            logger.warn(throwable.getMessage());
        }

        return null;
    }
}
