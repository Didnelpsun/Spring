// Logger.java
package org.didnelpsun.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
// 公共类用于记录日志
public class Logger {
    @Pointcut("execution(public * *..service.*Service.*User*(..))")
    private void expression(){}
    // 用于打印日志，用于在所有切入点方法即业务层方法执行之前执行
    // 前置通知
    @Before("expression()")
    public void beforePrintLog(){
        System.out.println("前置通知");
    }
    // 后置通知
    @AfterReturning("expression()")
    public void returnPrintLog(){
        System.out.println("后置通知");
    }
    // 异常通知
    @AfterThrowing("expression()")
    public void exceptionPrintLog(){
        System.out.println("异常通知");
    }
    // 最终通知
    @After("expression()")
    public void afterPrintLog(){
        System.out.println("最终通知");
    }
    // 环绕通知
    @Around("expression()")
    public Object aroundPrintLog(ProceedingJoinPoint proceedingJoinPoint){
        Object returnValue;
        System.out.println("环绕通知");
        try {
            // 获取方法执行所需参数
            Object[] args = proceedingJoinPoint.getArgs();
            System.out.println("前置通知");
            // 明确执行切入点方法即业务层方法
            returnValue = proceedingJoinPoint.proceed(args);
            System.out.println("后置通知");
            return returnValue;
        }catch (Throwable throwable){
            System.out.println("异常通知");
            throw new RuntimeException(throwable);
        }finally {
            System.out.println("最终通知");
        }
    }
}
