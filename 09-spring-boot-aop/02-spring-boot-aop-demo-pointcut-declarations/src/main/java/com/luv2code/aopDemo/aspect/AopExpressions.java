package com.luv2code.aopDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut("execution(* com.luv2code.aopDemo.repository.*.*(..))")
    public void forRepositoryPackage() {}

    @Pointcut("execution(* com.luv2code.aopDemo.repository.*.get*(..))")
    public void getters() {}

    @Pointcut("execution(* com.luv2code.aopDemo.repository.*.set*(..))")
    public void setters() {}

    @Pointcut("forRepositoryPackage() && !(getters() || setters())")
    public void forRepositoryPackageMethodsExcludingGettersAndSetters() {}
}
