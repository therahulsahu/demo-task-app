package com.example.demo.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class MeasureExecutionTimeAspect {

    @Around("@annotation(com.example.demo.annotation.MeasureExecutionTime)")
    public Object measureTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object proceed = proceedingJoinPoint.proceed();
        stopWatch.stop();
        System.out.printf("method [%s] is executing [%s] ms\n", proceedingJoinPoint.getSignature().getName(), stopWatch.getTotalTimeMillis());
        return proceed;
    }

}
