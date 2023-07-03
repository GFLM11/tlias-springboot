package com.itheima.service.impl;

import com.itheima.mapper.DeptMapper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Dept;
import com.itheima.pojo.DeptLog;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Slf4j
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private DeptLogServiceImpl deptLogService;

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Integer id) {
        try {
            //1.删除部门x
            deptMapper.delete(id);
            //2.删除部门x下的员工信息
            empMapper.deleteByDeptId(id);
        } finally {
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now(ZoneId.systemDefault()));
            deptLog.setDescription("部门解散操作已执行，解散部门的ID号为："+id);
            deptLogService.addLog(deptLog);
        }
    }

    @Override
    public void insert(Dept dept) {
        dept.setCreateTime(LocalDateTime.now(ZoneId.systemDefault()));
        dept.setUpdateTime(LocalDateTime.now(ZoneId.systemDefault()));
        deptMapper.insertDept(dept);
    }

    /*
    * 作用获取部门信息
    *   （1）通过ID获取原来的部门信息
    *   （2）修改部门信息
    * */
    @Override
    public Dept getDeptById(Integer id) {
        Dept dept = deptMapper.getDeptById(id);
        return dept;
    }
    @Override
    public void alterDept(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now(ZoneId.systemDefault()));
        deptMapper.alterDept(dept);
    }

}
