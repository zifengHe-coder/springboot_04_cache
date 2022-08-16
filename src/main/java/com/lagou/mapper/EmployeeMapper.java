package com.lagou.mapper;

import com.lagou.pojo.Employee;
import org.apache.ibatis.annotations.*;

/**
 * @author hezifeng
 * @create 2022/8/15 18:07
 */
public interface EmployeeMapper {
    @Select("select * from employee where id = #{id}")
    public Employee getEmpById(Integer id);

    @Insert("insert into employee(last_name, email, gender, d_id) values(#{lastName}, #{email}, #{gender}, #{dId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void insertEmp(Employee employee);

    @Update("update employee set last_name = #{lastName}, email = #{email}, gender = #{gender}, d_id = #{dId} where id = #{id}")
    public void updateEmp(Employee employee);

    @Delete("delete from employee where id = #{id}")
    public void deleteEmp(Integer id);
}
