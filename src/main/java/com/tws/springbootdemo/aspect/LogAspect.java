package com.tws.springbootdemo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author taoweishu
 * @date 2021/10/18 - 18:23
 */
@Aspect
@Component
@Slf4j
public class LogAspect {
    private  final Logger logger = LoggerFactory.getLogger(LogAspect.class);
    @Pointcut("execution(public * com.tws.springbootdemo.controller..*.*(..))")
    public void controllerMethod() {

    }
    @Before("controllerMethod()")
    public void LogRequestInfo(JoinPoint joinPoint) throws Exception {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        logger.info("################URL : " + request.getRequestURL().toString());
        logger.info("################HTTP_METHOD : " + request.getMethod());
        logger.info("################IP : " + request.getRemoteAddr());
        logger.info("################THE ARGS OF THE CONTROLLER : " + Arrays.toString(joinPoint.getArgs()));
    }
}
