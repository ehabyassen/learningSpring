package com.luv2code.aopDemo.aspect;

import com.luv2code.aopDemo.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Order(1)
@Component
public class DemoLoggingAspect {

    @Before("com.luv2code.aopDemo.aspect.AopExpressions.forRepositoryPackageMethodsExcludingGettersAndSetters()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Before Method Signature: " + signature);

        for (Object arg : joinPoint.getArgs()) {
            System.out.println("Before Method Argument: " + arg);
        }

        System.out.println(getClass() + ": logging info before addAccount...1");
    }

    @AfterReturning(
            pointcut = "execution(* com.luv2code.aopDemo.repository.AccountRepository.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println("After Method Signature: " + signature);
        System.out.println("After Method Result: " + result);
    }
}
