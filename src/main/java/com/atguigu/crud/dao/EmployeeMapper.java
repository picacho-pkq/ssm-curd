package com.atguigu.crud.dao;

import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.bean.EmployeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmployeeMapper {
    //用于查询用户名是否可用
    long countByExample(EmployeeExample example);

    //删除多个员工
    int deleteByExample(EmployeeExample example);
    //删除单个员工
    int deleteByPrimaryKey(Integer empId);



    int insert(Employee record);

    //插入一个新员工
    int insertSelective(Employee record);

    List<Employee> selectByExample(EmployeeExample example);

    //通过id获取员工
    Employee selectByPrimaryKey(Integer empId);
    
    List<Employee> selectByExampleWithDept(EmployeeExample example);

    Employee selectByPrimaryKeyWithDept(Integer empId);

    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}