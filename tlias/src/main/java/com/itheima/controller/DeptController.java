package com.itheima.controller;

import com.itheima.anno.Log;
import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.impl.DeptServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
//    private static Logger log = LoggerFactory.getLogger(DeptController.class);
//    @RequestMapping(value = "/depts", method = RequestMethod.GET)
    @Autowired
    private DeptServiceImpl deptService;
    /*
    *
    * 作用：查询部门全部数据
    * */
    @GetMapping
    public Result selectById(){
        log.info("查询部门全部数据");
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }
    /*
    *
    * 作用：删除部门
    * */
    @Log
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("删除部门记录的ID：{}",id);
        deptService.delete(id);
        return Result.success();
    }

    /*
    * 作用：新增部门信息
    *
    * */
    @Log
    @PostMapping
    public Result insert(@RequestBody Dept dept) {
        log.info("新增部门信息：{}",dept);
        deptService.insert(dept);
        return Result.success();
    }

    /*
    * 作用：根据ID查询部门
    *
    * */
    @GetMapping("/{id}")
    public Result getDeptById(@PathVariable Integer id) {
        log.info("获取到的部门ID：{}",id);
        Dept dept = deptService.getDeptById(id);
        return Result.success(dept);
    }


    /*
    *
    * 作用： 修改部门信息
    * */
    @Log
    @PutMapping
    public Result alter(@RequestBody Dept dept) {
        log.info("修改员工信息：{}",dept);
        deptService.alterDept(dept);
        return Result.success();
    }

}
