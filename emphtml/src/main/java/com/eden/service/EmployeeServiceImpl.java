package com.eden.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eden.dao.EmployeeDao;
import com.eden.entity.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeedao;
	
	@Override
	public List<Employee> lists() {
		
		return employeedao.lists();
	}

	@Override
	public void save(Employee employee) {
		
		employeedao.save(employee);
		
	}

	@Override
	public Employee findById(Integer id) {
		// TODO 自動生成されたメソッド・スタブ
		return employeedao.findById(id);
	}

	@Override
	public void update(Employee employee) {
		// TODO 自動生成されたメソッド・スタブ
		employeedao.update(employee);
	}

	@Override
	public void delete(Integer id) {
		// TODO 自動生成されたメソッド・スタブ
		employeedao.delete(id);
	}

	@Override
	public List<Employee> searchEmp(String searchName, String lowSalary, String topSalary, String dateBegin,
			String dateEnd) {
		// TODO 自動生成されたメソッド・スタブ
		return employeedao.searchEmp(searchName,lowSalary,topSalary,dateBegin,dateEnd);
	}

}
