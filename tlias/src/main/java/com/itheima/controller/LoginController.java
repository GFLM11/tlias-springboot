package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.Result;
import com.itheima.service.impl.EmpServiceImpl;
import com.itheima.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    private EmpServiceImpl empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        log.info("登录验证：{}", emp);
        Emp e = empService.login(emp);
        if (e != null) {
            Map<String,Object> claims = new HashMap<>();
            claims.put("id",e.getId());
            claims.put("username",e.getUsername());
            claims.put("name",e.getName());
            String jwtToken = JwtUtils.generateJwt(claims);
            return Result.success(jwtToken);
        }
        return Result.error("用户名或密码有误！");
    }
}
