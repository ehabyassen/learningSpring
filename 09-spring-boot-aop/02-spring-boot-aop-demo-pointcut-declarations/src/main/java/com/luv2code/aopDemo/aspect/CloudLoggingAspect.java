package com.luv2code.aopDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(3)
@Component
public class CloudLoggingAspect {

    @Before("com.luv2code.aopDemo.aspect.AopExpressions.forRepositoryPackageMethodsExcludingGettersAndSetters()")
    public void logToCloudAdvice() {
        System.out.println(getClass() + ": logging to cloud...3");
    }
}
