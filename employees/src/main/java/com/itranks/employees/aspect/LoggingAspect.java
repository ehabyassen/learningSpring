package com.itranks.employees.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Pointcut("execution(* com.itranks.employees.controller.*.*(..))")
    private void forControllerPackage() {}

    @Pointcut("execution(* com.itranks.employees.repository.*.*(..))")
    private void forRepositoryPackage() {}

    @Pointcut("execution(* com.itranks.employees.service.*.*(..))")
    private void forServicePackage() {}

    @Pointcut("forControllerPackage() || forRepositoryPackage() || forServicePackage()")
    private void forAppFlow() {}

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {
        logger.info("======> Entering Method: " + joinPoint.getSignature().toShortString());
        for (Object argument : joinPoint.getArgs()) {
            logger.info("=========> argument: " + argument);
        }
    }

    @AfterReturning(pointcut = "forAppFlow()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        logger.info("======> Exiting Method: " + joinPoint.getSignature().toShortString());
        logger.info("=========> result: " + result);
    }
}
