package com.example.jpatest01.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LogAdvice {

    private static final Logger log = LoggerFactory.getLogger(LogAdvice.class);

    @Around("execution(* com.example.jpatest01.controller..*Controller.*(..))"
            +" || execution(* com.example.jpatest01.service..*Service*.*(..))"
            +" || execution(* com.example.jpatest01.repository..*Repository.*(..))")
    public Object logPrint(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        
        //객체명
        String type = proceedingJoinPoint.getSignature().getDeclaringTypeName(); // 클래스명

        String methodeName = proceedingJoinPoint.getSignature().getName(); // 메서드명
        String parameters = Arrays.toString(proceedingJoinPoint.getArgs()); //파라미터
        
        
        //proceedingJoinPoint.getSignature().getName() <- 실행 메서드명
        log.info("[[START]]"+type+"."+proceedingJoinPoint.getSignature().getName()+"() <=================");
        log.info(""+ methodeName+"");
        log.info("Argument/Parameter : "+ Arrays.toString(proceedingJoinPoint.getArgs()));//<-파라미터

        log.info("================[[END : "+proceedingJoinPoint.getSignature().getName()+"()]]==================");

        return proceedingJoinPoint.proceed();
    }

}