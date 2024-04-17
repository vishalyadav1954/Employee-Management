package com.employee.repository;

import java.util.List;

import org.hibernate.*;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.entity.Employee;

@Repository
public class EmployeeRepository 
{
	private Session session;
	private Transaction transaction;
	
	@Autowired
	public EmployeeRepository(SessionFactory factory)
	{
		session=factory.openSession();
		transaction=session.getTransaction();
	}

	public void saveEmployee(Employee employee) 
	{
		transaction.begin();
		session.save(employee);
		transaction.commit();
	}

	public List<Employee> getEmployeeList() 
	{
		Query<Employee> query=session.createQuery("from Employee",Employee.class);
		List<Employee> empList=query.list();
		return empList;
	}

	public Employee getEmployee(int eid) 
	{
		Employee emp=session.get(Employee.class,eid);
		return emp;
	}

	public void deleteEmployee(Employee employee) 
	{
		transaction.begin();
		session.delete(employee);
		transaction.commit();
	}

	public void updateEmployee(Employee employeeo, Employee employeen) 
	{
		//code by you
	}
}
