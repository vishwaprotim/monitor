package com.protim.monitor.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingInterceptor {

    @Pointcut("execution( * com.protim.monitor.repository.StudentRepository.*(..))")
    public void repository() {
    }

    @Before("repository()")
    public void logBeforeRepo(JoinPoint jp) {
        log.info("Entering: " + jp.getSignature());
    }

    @After("repository()")
    public void logAfterRepo(JoinPoint jp) {
        log.info("Exiting: " + jp.getSignature());
    }
}
