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
 * File Name: TeacherServiceAspect
 * Package Name: com.java.code.aspect
 *
 * @author yipple
 * @date 2020/4/23
 * @since 0.0.1
 */
@Aspect
@Component
public class TeacherServiceAspect {

    private static final Logger logger = Logger.getLogger(TeacherServiceAspect.class);

    @Pointcut("execution(public * com.java.code.service..TeacherService*.*(..))")
    public void matchedTeacherServiceMethod() {
    }

    @Around("matchedTeacherServiceMethod()")
    public Object aroundServiceMethod(ProceedingJoinPoint pjp) {
        logger.debug("-------------------------");
        logger.debug("TeacherService中的方法被调用");
        Object result = null;

        try {
            logger.debug("方法签名：" + pjp.getSignature());
            logger.debug("连接点类型：" + pjp.getKind());
            Object[] args = pjp.getArgs();
            logger.debug("方法参数：" + Arrays.toString(args));
            logger.debug("被代理的对象：" + pjp.getTarget());
            result = pjp.proceed(args);
            logger.debug("执行结果：" + result);
        } catch (Throwable throwable) {
            logger.error(throwable.getMessage());
        }

        logger.debug("-------------------------");
        return result;
    }
}
