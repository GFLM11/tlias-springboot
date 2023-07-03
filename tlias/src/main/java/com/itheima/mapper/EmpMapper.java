package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    /*
     * 作用：源码实现 不带条件的分页查询
     * */
//    @Select("SELECT COUNT(*) FROM emp")
//    Long allCount();

//    @Select("SELECT * FROM emp LIMIT #{start},#{pageSize}")
//    List<Emp> pagingWithoutCon(int start, Integer pageSize);

    /*
    * 作用：分页插件实现 员工条件查询分页版
    * */
//    @Select("SELECT * FROM emp WHERE name LIKE CONCAT('%','张','%') AND gender = 1 AND entrydate " +
//            "BETWEEN '2000-1-1' AND '2010-1-1' ORDER BY update_time DESC ")
    List<Emp> list(String name, Short gender, LocalDate begin,LocalDate end);

    //    @Delete("DELETE FROM emp WHERE id IN (1,2,3)")
    void deleteEmp(List<Integer> ids);

    @Insert("INSERT INTO emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "VALUES(#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime}) ")
    void add(Emp emp);

    @Select("SELECT * FROM emp WHERE id = #{id}")
    Emp findById(Integer id);

    void updateEmp(Emp emp);

    @Select("SELECT * FROM emp WHERE username = #{username} AND password = #{password}")
    Emp getByUsernameAndPassword(Emp emp);

    /*
    *
    * 作用：根据部门id删除员工信息
    * */
    @Delete("DELETE FROM emp WHERE dept_id = #{deptId}")
    void deleteByDeptId(Integer deptId);
}
