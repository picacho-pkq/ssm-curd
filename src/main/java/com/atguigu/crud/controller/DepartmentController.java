package com.atguigu.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.crud.bean.Department;
import com.atguigu.crud.bean.Msg;
import com.atguigu.crud.service.DepartmentService;

/**
 * 处理和部门有关的请求
 * @author lfy
 *
 */
@Controller
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	/**
	 * 返回所有的部门信息
	 */
	//这里是返回的是自定义对象
	@RequestMapping("/depts")
	@ResponseBody
	public Msg getDepts(){
		//查出的所有部门信息
		List<Department> list = departmentService.getDepts();
		//success()返回的依旧是一个Msg对象，添加了成功的相关信息，然后调用add()方法加入要返回的数据信息
		//前端可以通过depts的键值，获得其对应的list集合，里面包含部门信息
		return Msg.success().add("depts", list);
	}

}
