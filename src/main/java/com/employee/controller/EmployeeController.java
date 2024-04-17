package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

@Controller
public class EmployeeController 
{
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/")
	public String getHomeView()
	{
		return "home.jsp";
	}
	@RequestMapping("add-form")
	public String getAddFormView()
	{
		return "add.jsp";
	}
	@RequestMapping("add-record")
	public String saveEmployeeRecord(Employee employee)
	{
		employeeService.saveRecord(employee);
		return "add-success.jsp";
	}
	@RequestMapping("employee-list")
	public String getEmployeeList(Model model)
	{
		List<Employee> employeeList=employeeService.getList();
		model.addAttribute("elist",employeeList);
		return "list.jsp";
	}
	@RequestMapping("search-form")
	public String getSearchFormView()
	{
		return "search.jsp";
	}
	@RequestMapping("search-record")
	public String searchEmployeeRecord(int eid,Model model)
	{
		Employee employee=employeeService.getRecord(eid);
		if(employee==null)
		{
			model.addAttribute("msg","Record not found");
			model.addAttribute("eid",eid);
			return "search.jsp";
		}
		model.addAttribute("emp",employee);
		return "show-employee.jsp";
	}
	@RequestMapping("delete-form")
	public String getDeleteFormView()
	{
		return "delete.jsp";
	}
	@RequestMapping("delete-record")
	public String deleteEmployeeRecord(int eid,Model model)
	{
		Employee employee=employeeService.getRecord(eid);
		if(employee==null)
		{
			model.addAttribute("msg","Record does not exist");
		}
		else
		{
			employeeService.deleteRecord(employee);
			model.addAttribute("msg","Employee record has been deleted");
		}
		model.addAttribute("eid",eid);
		return "delete.jsp";
	}
	@RequestMapping("edit-form")
	public String getEditFormView()
	{
		return "edit.jsp";
	}
	@RequestMapping("show-record")
	public String showEmployeeRecord(int eid,Model model)
	{
		Employee employee=employeeService.getRecord(eid);
		if(employee==null)
		{
			model.addAttribute("msg","Record not found");
			model.addAttribute("eid",eid);
			return "edit.jsp";
		}
		model.addAttribute("emp",employee);
		return "get-employee.jsp";
	}
	@RequestMapping("update-record")
	public String updateEmployeeRecord(Employee employee)
	{
		employeeService.updateRecord(employee);
		return "update-success.jsp";
	}
}
