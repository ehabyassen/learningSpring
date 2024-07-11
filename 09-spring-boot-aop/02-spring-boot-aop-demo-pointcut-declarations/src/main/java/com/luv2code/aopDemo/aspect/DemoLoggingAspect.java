package com.luv2code.aopDemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class DemoLoggingAspect {

    @Before("com.luv2code.aopDemo.aspect.AopExpressions.forRepositoryPackageMethodsExcludingGettersAndSetters()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + signature);

        for (Object arg : joinPoint.getArgs()) {
            System.out.println("Argument: " + arg);
        }

        System.out.println(getClass() + ": logging info before addAccount...1");
    }
}
