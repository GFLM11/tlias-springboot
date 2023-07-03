package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component  //如果代理的方法被应用，注入的对象会变成代理对象
public class TimeAspect {
    @Around("execution(* com.itheima.service.*.*(..))") //切入点表达式
    public Object recordTime(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = pjp.proceed();
        long end = System.currentTimeMillis();
        long times = end - start;
        log.info(pjp.getSignature() + "方法耗时：{}",times);
        return result;
    }
}
