package com.itheima.config;

import org.springframework.context.annotation.Configuration;

/*
*   作用：将第三方对象加入IOC容器
*   重点：
*       1、方法上加上@Bean注解
*       2、方法返回值设置为第三方对象
*       3、例：return(new Xxx());
* */
@Configuration
public class CommonConfig {

}
