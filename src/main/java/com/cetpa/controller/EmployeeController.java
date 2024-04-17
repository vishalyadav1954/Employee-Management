package com.cetpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cetpa.entity.Employee;
import com.cetpa.service.EmployeeService;

@Controller
@RequestMapping("employee-dashboard")
public class EmployeeController 
{
	@Autowired private EmployeeService employeeService;
	
	@GetMapping("")
	public String getEmployeeDashboard(Model model)
	{
		List<Employee> employeeList=employeeService.getList();
		model.addAttribute("elist",employeeList);
		return "list";
	}
	@GetMapping("add-employee")
	public String getAddEmployeeView()
	{
		return "add";
	}
	@PostMapping("add-record")
	public String addEmployeeRecord(Employee employee)
	{
		employeeService.saveRecord(employee);
		return "redirect:/employee-dashboard";
	}
	@RequestMapping("delete-record")
	public String deleteEmployeeRecord(int eid)
	{
		employeeService.deleteRecord(eid);
		return "redirect:/employee-dashboard";
	}
}
