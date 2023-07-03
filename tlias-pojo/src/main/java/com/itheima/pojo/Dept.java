package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept {
    private Integer id; //id
    private String name;    //部门名称
    private LocalDateTime createTime;   //创建日期
    private LocalDateTime updateTime;   //更新日期
}
