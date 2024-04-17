package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeService 
{
	@Autowired
	private EmployeeRepository employeeRepository;

	public void saveRecord(Employee employee) 
	{
		employeeRepository.saveEmployee(employee);
	}

	public List<Employee> getList() 
	{
		return employeeRepository.getEmployeeList();
	}
	public Employee getRecord(int eid) 
	{
		return employeeRepository.getEmployee(eid);
	}

	public void deleteRecord(Employee employee) 
	{
		employeeRepository.deleteEmployee(employee);
	}

	public void updateRecord(Employee employeen) 
	{
		Employee employeeo=employeeRepository.getEmployee(employeen.getEid());
		employeeRepository.updateEmployee(employeeo,employeen);
	}
	
}
