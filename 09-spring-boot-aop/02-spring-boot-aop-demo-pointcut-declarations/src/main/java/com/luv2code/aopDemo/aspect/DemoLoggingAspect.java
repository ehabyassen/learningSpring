package com.luv2code.aopDemo.aspect;

import com.luv2code.aopDemo.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
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

        System.out.println(getClass() + ": logging info before...1");
    }

    @AfterReturning(
            pointcut = "execution(* com.luv2code.aopDemo.repository.AccountRepository.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println("After Returning Method Signature: " + signature);

        result.forEach(account -> account.setName(account.getName().toUpperCase()));

        System.out.println("After Returning Method Result: " + result);
    }

    @AfterThrowing(
            pointcut = "execution(* com.luv2code.aopDemo.repository.AccountRepository.findAccounts(..))",
            throwing = "exception")
    public void afterThrowingFindAccountsAdvice(Throwable exception) {
        System.out.println("After Throwing Exception: " + exception.getMessage());
    }

    @After("execution(* com.luv2code.aopDemo.repository.AccountRepository.findAccounts(..))")
    public void afterFindAccountsAdvice(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println("After Method Signature: " + signature);
    }
}
