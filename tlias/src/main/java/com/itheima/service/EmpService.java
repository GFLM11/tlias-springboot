package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    /*
     * 作用：分页获取员工信息
     * */
    PageBean getPageWithEmp(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    /*
    * 作用：删除员工信息
    * */
    void deleteEmp(List<Integer> ids);

    void add(Emp emp);

    // 作用：根据ID查询员工数据
    Emp getById(Integer id);

    //作用：修改员工
    void update(Emp emp);

    //作用：用户登录
    Emp login(Emp emp);
}
