package com.stone.mybatis.dao;

import com.stone.mybatis.bean.Employee;

public interface EmployeeMapper {
	public Employee getEmpById(Integer id);
}