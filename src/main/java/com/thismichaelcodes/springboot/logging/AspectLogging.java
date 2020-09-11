package com.thismichaelcodes.springboot.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
@Component
public class AspectLogging {

    private Logger log = LoggerFactory.getLogger(this.getClass());

//    Show how to use these to omit functions.
//    @Pointcut("within(com.thismichaelcodes.springboot.controllers..*)")
//    public void theControllers() {}
//
//    @Pointcut("within(com.thismichaelcodes.springboot.managers..*)")
//    public void theManagers() {}

    @Before("execution(* com.thismichaelcodes.springboot..*(..))")
    public void before(JoinPoint joinPoint) {
        log.info("Calling: {}{}.", joinPoint.getSignature().getName(), joinPoint.getArgs());
    }

    @AfterReturning(value = "execution(* com.thismichaelcodes.springboot..*(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        log.info("{}() returned with: {}", joinPoint.getSignature().getName(), result);
    }

}
