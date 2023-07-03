package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
    @Select("SELECT * FROM dept")
    List<Dept> list();

    @Delete("DELETE FROM dept WHERE id = #{id}")
    void delete(Integer id);

    @Insert("INSERT INTO dept(name, create_time, update_time) VALUES (#{name},#{createTime},#{updateTime})")
    void insertDept(Dept dept);

    @Select("SELECT * FROM dept WHERE id = #{id}")
    Dept getDeptById(Integer id);

    @Update("UPDATE dept SET name=#{name},update_time=#{updateTime} WHERE id=#{id}")
    void alterDept(Dept dept);
}
