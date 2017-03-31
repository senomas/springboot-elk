package com.senomas.bootapp.rest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

    @Pointcut("@annotation(com.senomas.bootapp.rest.Loggable)")
    public void loggableMethods() {
    }

    @Before("loggableMethods()")
    public void logMethod(JoinPoint jp) {
    	String typeName = jp.getSignature().getDeclaringTypeName();
        String methodName = jp.getSignature().getName();
        log.info("LOG-ENTER "+typeName+"."+methodName);
    }
}