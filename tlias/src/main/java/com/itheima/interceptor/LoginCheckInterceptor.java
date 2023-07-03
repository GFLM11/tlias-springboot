package com.itheima.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.itheima.pojo.Result;
import com.itheima.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1.获取token，判断token是否为空
        String token = request.getHeader("token");
        log.info("浏览器中获取到的token：{}",token);
        if (token == null || token.isEmpty()) {
            log.info("token不存在！");
            Result result = Result.error("NOT_LOGIN");
            String json = JSONObject.toJSONString(result);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);
            return false;
        }
        //2.解析token，捕获异常情况
        try {
            Claims claims = JwtUtils.parseJWT(token);
        } catch (Exception e) {
            log.info("令牌解析失败！");
            Result result = Result.error("NOT_LOGIN");
            String json = JSONObject.toJSONString(result);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);
            return false;
        }
        //3.放行
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle .... ");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion .... ");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
