package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;


    /*
    * 作用；条件查询并分页展示
    * */
    @Override
    public PageBean getPageWithEmp(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        PageHelper.startPage(page,pageSize);
        List<Emp> empList = empMapper.list(name,gender,begin,end);
        Page<Emp> empPage = (Page<Emp>) empList;
        return new PageBean(empPage.getTotal(),empPage.getResult());
    }

    @Override
    public void deleteEmp(List<Integer> ids) {
        empMapper.deleteEmp(ids);
    }

    /*
    * 作用：新增员工
    * */
    @Override
    public void add(Emp emp) {
        //1.补全基本信息
        emp.setCreateTime(LocalDateTime.now(ZoneId.systemDefault()));
        emp.setUpdateTime(LocalDateTime.now(ZoneId.systemDefault()));
        empMapper.add(emp);
    }

    @Override
    public Emp getById(Integer id) {
        return empMapper.findById(id);
    }

    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now(ZoneId.systemDefault()));
        empMapper.updateEmp(emp);
    }

    @Override
    public Emp login(Emp emp) {
        return empMapper.getByUsernameAndPassword(emp);
    }

//    @Override
//    public PageBean getPageWithEmp(Integer page, Integer pageSize) {
//        Long allCount = empMapper.allCount();
//        int begin = ((page - 1)*pageSize);
//        List<Emp> empList = empMapper.pagingWithoutCon(begin,pageSize);
//        PageBean pageBean = new PageBean(allCount,empList);
//        return pageBean;
//    }

}
