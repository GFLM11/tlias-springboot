package com.itheima.controller;

import com.itheima.anno.Log;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Result;
import com.itheima.service.impl.EmpServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpServiceImpl empService;

    /*
     *
     * 作用：获取员工信息，以分页的形式展示
     * 参数1：page => 页码
     * 参数2：pageSize => 每页记录数
     *
     * */
    @GetMapping
    public Result getPageWithEmp(@RequestParam(defaultValue = "1") Integer page,
                                 @RequestParam(defaultValue = "10") Integer pageSize,
                                 String name, Short gender,
                                 @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate begin,
                                 @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate end)
    {
        log.info("分页查询员工信息：{}，{}，{}，{} ",name,gender,begin,end);
        PageBean pageBean = empService.getPageWithEmp(page,pageSize,name,gender,begin,end);
        return Result.success(pageBean);
    }

    /*
    * 作用：批量删除员工
    *
    * */
    @Log
    @DeleteMapping("/{ids}")
    public Result deleteEmp(@PathVariable List<Integer> ids) {
        log.info("删除员工：{}",ids);
        empService.deleteEmp(ids);
        return Result.success();
    }

    /*
    * 作用；新增员工
    * */
    @Log
    @PostMapping
    public Result add(@RequestBody Emp emp) {
        log.info("新增员工信息：{}",emp);
        empService.add(emp);
        return Result.success();
    }

    /*
    * 作用：根据ID查询员工信息
    * */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("根据ID查询，id：{}",id);
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }

    /*
    * 作用：修改员工
    * */
    @Log
    @PutMapping
    public Result update(@RequestBody Emp emp) {
        log.info("更新员工信息，emp：{}",emp);
        empService.update(emp);
        return Result.success();
    }
}
