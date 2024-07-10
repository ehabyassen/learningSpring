package com.luv2code.aopDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(2)
@Component
public class ApiAnalyticsAspect {

    @Before("com.luv2code.aopDemo.aspect.AopExpressions.forRepositoryPackageMethodsExcludingGettersAndSetters()")
    public void performSomeApiAnalyticsAdvice() {
        System.out.println(getClass() + ": performing some api analytics...2");
    }
}
