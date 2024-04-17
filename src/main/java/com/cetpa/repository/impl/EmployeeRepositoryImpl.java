package com.cetpa.repository.impl;

import java.util.List;

import org.hibernate.*;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cetpa.entity.Employee;
import com.cetpa.repository.EmployeeRepository;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository 
{
	private Session session;
	private Transaction transaction;
	
	@Autowired
	public EmployeeRepositoryImpl(SessionFactory factory)
	{
		session=factory.openSession();
		transaction=session.getTransaction();
	}
	public List<Employee> getEmployeeList() 
	{
		Query<Employee> query=session.createQuery("from Employee",Employee.class);
		return query.list();
	}
	public void saveEmployee(Employee employee) 
	{
		transaction.begin();
		session.persist(employee);
		transaction.commit();
	}
	public void deleteEmployee(Employee epmloyee) 
	{
		transaction.begin();
		session.delete(epmloyee);
		transaction.commit();
	}
	public Employee getEmployee(int eid) 
	{
		return session.get(Employee.class,eid);
	}
}
