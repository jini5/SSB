package com.cafe.admin.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

@Component
@Aspect
public class AuthAspect {
    @Pointcut(" execution(* com.cafe.admin.controller.*.*(..))")
    public void cut(){}

    @Around("cut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        HttpSession session=((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();

        if(session.getAttribute("admin")==null){ //로그인을 했을때
            return null;
        }else {// 로그인을 안했을때
            return joinPoint.proceed();
        }
    }


}
