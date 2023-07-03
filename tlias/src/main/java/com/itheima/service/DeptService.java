package com.itheima.service;


import com.itheima.pojo.Dept;

import java.util.List;

public interface DeptService {
    /*
    * 作用：查询部门表全部信息
    *
    * */
    List<Dept> list();

    /*
    * 作用:根据ID删除部门信息
    *
    * */
    void delete(Integer id);

    /*
    * 作用：新增部门信息
    * */
    void insert(Dept dept);

    /*
    *
    * 作用：通过ID获取部门信息
    * */
    Dept getDeptById(Integer id);

    /*
    * 作用：修改员工信息
    * */
    void alterDept(Dept dept);
}
