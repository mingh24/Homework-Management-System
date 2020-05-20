package com.java.code.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Project Name: Homework-Management-System
 * File Name: StudentServiceAspect
 * Package Name: com.java.code.aspect
 *
 * @author yipple
 * @date 2020/4/23
 * @since 0.0.1
 */
@Aspect
@Component
public class StudentServiceAspect {

    private static final Logger logger = Logger.getLogger(StudentServiceAspect.class);

    @Pointcut("execution(public * com.java.code.service..StudentService*.*(..))")
    public void matchedStudentServiceMethod() {
    }

    @Around("matchedStudentServiceMethod()")
    public Object aroundServiceMethod(ProceedingJoinPoint pjp) {
        logger.debug("StudentService中的方法被调用");
        Object result = null;

        try {
            Object[] args = pjp.getArgs();
            logger.debug("方法参数：" + Arrays.toString(args));
            logger.debug("被代理的对象：" + pjp.getTarget());
            result = pjp.proceed(args);
            logger.debug("结果：" + result);
        } catch (Throwable throwable) {
            logger.error(throwable.getMessage());
        }

        return result;
    }

}
