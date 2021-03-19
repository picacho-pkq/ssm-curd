package com.atguigu.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.bean.EmployeeExample;
import com.atguigu.crud.bean.EmployeeExample.Criteria;
import com.atguigu.crud.dao.EmployeeMapper;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeMapper employeeMapper;

	/**
	 * 查询所有员工
	 * @return
	 */
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return employeeMapper.selectByExampleWithDept(null);
	}

	/**
	 * 员工保存
	 * @param employee
	 */
	public void saveEmp(Employee employee) {
		// TODO Auto-generated method stub
		employeeMapper.insertSelective(employee);
	}

	/**
	 * 检验用户名是否可用
	 * 
	 * @param empName
	 * @return  true：代表当前姓名可用   fasle：不可用
	 */
	public boolean checkUser(String empName) {
		// TODO Auto-generated method stub
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmpNameEqualTo(empName);
		long count = employeeMapper.countByExample(example);
		//如果count = 0表示返回真，表示可用
		return count == 0;
	}

	/**
	 * 按照员工id查询员工
	 * @param id
	 * @return
	 */
	public Employee getEmp(Integer id) {
		// TODO Auto-generated method stub
		Employee employee = employeeMapper.selectByPrimaryKey(id);
		return employee;
	}

	/**
	 * 员工更新
	 * @param employee
	 */
	public void updateEmp(Employee employee) {
		// TODO Auto-generated method stub
		employeeMapper.updateByPrimaryKeySelective(employee);
	}

	/**
	 * 员工删除
	 * @param id
	 */
	//删除单个员工
	public void deleteEmp(Integer id) {
		// TODO Auto-generated method stub
		employeeMapper.deleteByPrimaryKey(id);
	}

    //批量删除多个员工,这里采用了逆向工程自动生成的方法
	public void deleteBatch(List<Integer> ids) {
		// TODO Auto-generated method stub
		//无参构造同时创建了一个集合对象oredCriteria，这个集合存放criteria对象
		EmployeeExample example = new EmployeeExample();
		//example对象中的oredCriteria集合存放了一个criteria对象
		Criteria criteria = example.createCriteria();
		//这里起到了拼接删除条件的作用
		//delete from xxx where emp_id in(1,2,3)
		criteria.andEmpIdIn(ids);
		employeeMapper.deleteByExample(example);
	}

}
