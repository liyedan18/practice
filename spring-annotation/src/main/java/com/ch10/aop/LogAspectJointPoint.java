package com.ch10.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

/**
 * 切面类
 * 带参数JoinPoint
 */
@Aspect
public class LogAspectJointPoint {

    @Pointcut("execution(public int com.ch10.aop.Calculator.*(..))")
    public void pointCut(){
    }

    // 使用JoinPoint可以拿到相关的内容，比如方法名，方法参数
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName() + "...运行之前。。。参数是：" + Arrays.asList(joinPoint.getArgs()));
    }

    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName() + "...运行结束。。。");
    }

    // 可以获取到方法的返回值，returning定义返回参数名
    @AfterReturning(value = "pointCut()", returning = "resultData")
    public void logReturn(Object resultData){
        System.out.println("运行正常返回..." + resultData);
    }

    // throwing获取异常信息,参数exception用来接收异常
    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logException(Exception exception){
        System.out.println("运行出现异常..." + exception);
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
