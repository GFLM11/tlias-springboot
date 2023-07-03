package com.itheima.mapper;

import com.itheima.pojo.DeptLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptLogMapper {
    @Insert("INSERT INTO dept_log(create_time, description) VALUES(#{createTime},#{description})")
    public void insertLog(DeptLog deptLog);
}
