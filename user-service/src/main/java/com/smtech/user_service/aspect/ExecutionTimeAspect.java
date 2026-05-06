/**
 * @author SEHAN MADUSHANKA
 * @email sehanmadushanka0714@gmail.com
 * @contact +94776925883
 * @created 5/6/2026
 * <p>
 * Description: ExecutionTimeAspect class handles ...
 */

package com.smtech.user_service.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

@Aspect
@Component
@Slf4j
public class ExecutionTimeAspect {

    @Pointcut("execution(* com.smtech.user_service.controller.*.*(..))")
    public void controllerMethod() {}


    @Around("controllerMethod()")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        long star = System.nanoTime();
        try{
            return joinPoint.proceed();
        }finally{
            long end = System.nanoTime();

            long elapsedNs = end - star;
            long elapsedMs = TimeUnit.NANOSECONDS.toMillis(elapsedNs);

            String signature = joinPoint.getSignature().toShortString();
            log.info("Controller method {} executed in {} ms", signature, elapsedMs);

        }
    }
}
