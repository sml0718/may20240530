package com.eden.dao;

import java.util.List;

import com.eden.entity.Employee;

public interface EmployeeDao {

	List<Employee> lists();

	void save(Employee employee);

	Employee findByID();

	Employee findById(Integer id);

	void update(Employee employee);

	void delete(Integer id);

	List<Employee> searchEmp(String searchName, String lowSalary, String topSalary, String dateBegin, String dateEnd);

}
