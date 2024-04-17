package com.cetpa.service;

import java.util.List;

import com.cetpa.entity.Employee;

public interface EmployeeService 
{
	List<Employee> getList();
	void saveRecord(Employee employee);
	void deleteRecord(int eid);
}
