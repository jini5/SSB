package com.example.demoxenium.aop;

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
public class LoginAop {

    @Pointcut("execution(* com.example.demoxenium.member.controller.MemberController.*(..))")
    public void cut(){};

    @Around("cut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        HttpSession session =((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();

        if(session.getAttribute("id")==null){
            return null;
        }else { //로그인 안했을 때
            return joinPoint.proceed();
        }
    }


}
