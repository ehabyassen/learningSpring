package com.luv2code.aopDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {

    @Pointcut("execution(* com.luv2code.aopDemo.repository.*.*(..))")
    private void forRepositoryPackage() {}

    @Pointcut("execution(* com.luv2code.aopDemo.repository.*.get*(..))")
    private void getters() {}

    @Pointcut("execution(* com.luv2code.aopDemo.repository.*.set*(..))")
    private void setters() {}

    @Pointcut("forRepositoryPackage() && !(getters() || setters())")
    private void forRepositoryPackageMethodsExcludingGettersAndSetters() {}

    @Before("forRepositoryPackageMethodsExcludingGettersAndSetters()")
    public void beforeAnyMethodAdvice() {
        System.out.println(getClass() + ": logging info before executing any method in the declared package except excluded methods...");
    }
}
