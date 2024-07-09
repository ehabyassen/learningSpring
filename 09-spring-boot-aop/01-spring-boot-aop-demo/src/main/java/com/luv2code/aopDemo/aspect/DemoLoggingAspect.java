package com.luv2code.aopDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {

    @Pointcut("execution(* com.luv2code.aopDemo.repository.*.*(..)")
    private void daoPackageAdvice() {
        System.out.println(getClass() + ": logging info before any method in the declared package...");
    }

    @Before("daoPackageAdvice()")
    public void beforeAddAccountAdvice() {
        
    }
}
