package com.itheima.aop;

import com.alibaba.fastjson.JSONObject;
import com.itheima.mapper.OperateLogMapper;
import com.itheima.pojo.OperateLog;
import com.itheima.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;

@Aspect
@Slf4j
@Component
public class LogAspect {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private OperateLogMapper plm;

    @Around("@annotation(com.itheima.anno.Log)")
    public Object recordLog(ProceedingJoinPoint pjp) throws Throwable {
        String token = request.getHeader("token");
        Claims claims = JwtUtils.parseJWT(token);
        //操作员工ID
        Integer operateUser = (Integer) claims.get("id");
        //操作时间
        LocalDateTime operateTime = LocalDateTime.now(ZoneId.systemDefault());
        //操作类名
        String className = pjp.getTarget().getClass().getName();
        //获取方法名
        String methodName = pjp.getSignature().getName();
        //参数
        Object[] args = pjp.getArgs();
        String methodParams = Arrays.toString(args);
        long begin = System.currentTimeMillis();
        //调用原始目标方法得到结果
        Object result = pjp.proceed();
        long end = System.currentTimeMillis();
        //操作方法的返回值
        String returnValue = JSONObject.toJSONString(result);
        //操作耗时
        Long costTime = end - begin;
        //操作员日志对象
        OperateLog operateLog = new OperateLog(null, operateUser, operateTime, className, methodName, methodParams,
                returnValue, costTime);
        plm.insert(operateLog);
        log.info("AOP记录日志操作：{}",operateLog);
        return result;
    }
}
