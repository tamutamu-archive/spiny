package com.gioov.spiny.common.annotation.loggingoperation;

import com.gioov.spiny.user.entity.UserEntity;
import com.gioov.spiny.user.service.UserService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author godcheese
 * @date 2018-08-03
 */
@Component
@Aspect
public class LoggingOperationAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingOperationAspect.class);

    @Autowired
    private UserService userService;

    @Pointcut("@annotation(logOperation)")
    public void logAnnotationPointcut(LoggingOperation logOperation){
    }

    @Before("logAnnotationPointcut(logOperation)")
    public void before(JoinPoint joinPoint, LoggingOperation logOperation){

        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            LOGGER.info("arg={}", arg);
        }

        Long userId = null;

        UserEntity userEntity = userService.getCurrentUser();
        if(userEntity!=null) {
            userId =userEntity.getId();
        }

        MethodSignature methodSignature =  (MethodSignature) joinPoint.getSignature();

        Method method = methodSignature.getMethod();

        LoggingOperation annotation = method.getAnnotation(LoggingOperation.class);

        LOGGER.info("userId={}, methodName={}, operationType={}, operation={}", userId, method.getName(), annotation.operationType().value(), annotation.value());

    }

}
