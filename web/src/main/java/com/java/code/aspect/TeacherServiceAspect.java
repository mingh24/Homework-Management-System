package com.java.code.aspect;

import com.java.code.jdbc.TransactionManager;
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

    private final TransactionManager transactionManager;

    public TeacherServiceAspect(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    @Pointcut("execution(public * com.java.code.service..TeacherService*.*(..))")
    public void matchedTeacherServiceMethod() {
    }

    @Around("matchedTeacherServiceMethod()")
    public Object aroundServiceMethod(ProceedingJoinPoint pjp) {
        System.out.println("-----Before teacherServiceMethod-----");

        transactionManager.beginTransaction();

        Object result = null;

        try {
            Object[] args = pjp.getArgs();
            System.out.println("方法参数：" + Arrays.toString(args));
            System.out.println("被代理的对象：" + pjp.getTarget());
            result = pjp.proceed(args);
            System.out.println("-----After teacherServiceMethod returning-----");
            transactionManager.commit();
        } catch (Throwable throwable) {
            System.out.println("-----After teacherServiceMethod throwing-----");
            transactionManager.rollback();
            throwable.printStackTrace();
        } finally {
            System.out.println("-----Finally teacherServiceMethod-----");
        }

        return result;
    }
}
