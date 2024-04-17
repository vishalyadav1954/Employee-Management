package com.cetpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.entity.Employee;
import com.cetpa.repository.EmployeeRepository;
import com.cetpa.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService 
{
	@Autowired private EmployeeRepository employeeRepository;

	public List<Employee> getList() 
	{
		return employeeRepository.getEmployeeList();
	}
	public void saveRecord(Employee employee) 
	{
		employeeRepository.saveEmployee(employee);
	}
	public void deleteRecord(int eid) 
	{
		Employee employee=employeeRepository.getEmployee(eid);
		employeeRepository.deleteEmployee(employee);
	}
}
