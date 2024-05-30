package com.eden.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eden.dao.EmployeeDao;
import com.eden.entity.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public void add(Employee employee) {
		// TODO 自動生成されたメソッド・スタブ
		employeeDao.add(employee);
	}

	@Override
	public List<Employee> list() {
		// TODO 自動生成されたメソッド・スタブ
		return employeeDao.list();
	}

	@Override
	public void delete(Integer id) {
		// TODO 自動生成されたメソッド・スタブ
		employeeDao.delete(id);
	}

	@Override
	public Employee idByEmployee(Integer id) {
		// TODO 自動生成されたメソッド・スタブ
		return employeeDao.idByEmployee(id);
	}

	@Override
	public void update(Employee employee) {
		// TODO 自動生成されたメソッド・スタブ
		employeeDao.update(employee);
	}

	@Override
	public List<Employee> searchEmp(String searchname, String dateBegin, String dateEnd) {
		// TODO 自動生成されたメソッド・スタブ
		return employeeDao.searchEmp(searchname,dateBegin,dateEnd);
	}

	
	}


	

	 

