package com.eden.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eden.entity.Employee;
import com.eden.service.EmployeeService;

@Controller
@RequestMapping("employee")
public class EmployeeController {
		
	private static final Logger log=LoggerFactory.getLogger(EmployeeController.class);
	
	@RequestMapping("search")
	public String searchEmp(String searchname,String dateBegin,String dateEnd,Model model) {
		log.debug("検索名前:{},誕生日:{},{}",searchname,dateBegin,dateEnd);
		
		searchname=searchname.trim();
		
		dateBegin=dateBegin.trim();
		
		dateEnd=dateEnd.trim();
		
		
		List<Employee> employee = employeeService.searchEmp(searchname,dateBegin,dateEnd);
		
		model.addAttribute("employee",employee);
		return"emplist";
	}
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("update")
	public String updateEmployee(Employee employee) {
		log.debug("名前:{},誕生日:{},月給:{},性別:{}",
				employee.getName(),employee.getBirthday(),employee.getSalary(),employee.isGender());
		
		employeeService.update(employee);
		
		return "redirect:/employee/list";
		
	}
	
	@RequestMapping("detail")
	public String detailEmployee(Integer id, Model model) {
		
		log.debug("更新ID:{}",id);
		
		Employee employee=employeeService.idByEmployee(id);
		
		model.addAttribute("employee",employee);
		
		return "updateEmp";
		
	}
	
	@RequestMapping("delete")
	public String deleteEmployee(Integer id) {
		log.debug("削除したID:{}",id);
		
		employeeService.delete(id);
		
		return"redirect:/employee/list";
	}
	
	@GetMapping("list")
	public String listEmployee(Model model) {
		
		List<Employee>employee=employeeService. list();
		
		model.addAttribute("employee", employee);
		
		return"emplist";
	}
	
	@PostMapping("add")
	public String addEmployee(Employee employee) {
		
		
		log.debug("名前:{},誕生日:{},月給:{},性別:{}",
				employee.getName(),employee.getBirthday(),employee.getSalary(),employee.isGender());
		
		employeeService.add(employee);
		
		return "redirect:/employee/list";
		
		
	}

}
