package com.ch10.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 切面类
 */
@Aspect
public class LogAspect {

    @Pointcut("execution(public int com.ch10.aop.Calculator.*(..))")
    public void pointCut(){
    }

    @Before("pointCut()")
    public void logStart(){
        System.out.println("运行之前。。。");
    }

    @After("pointCut()")
    public void logEnd(){
        System.out.println("运行结束。。。");
    }

    @AfterReturning("pointCut()")
    public void logReturn(){
        System.out.println("运行正常返回...");
    }

    @AfterThrowing("pointCut()")
    public void logException(){
        System.out.println("运行出现异常...");
    }

    /**
     * 如果调用的方法有返回值，就不能用下面这种方式，会导致方法没有返回值。
     */
    // @Around("pointCut()")
    // public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
    //     System.out.println("@Around:方法执行之前...");
    //     //相当于调用div()
    //     joinPoint.proceed();
    //     System.out.println("@Around:方法执行之后...");
    // }

    @Around("pointCut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("@Around:方法执行之前...");
        //相当于调用div()
        Object o = joinPoint.proceed();
        System.out.println("@Around:方法执行之后...");
        return o;
    }

}
