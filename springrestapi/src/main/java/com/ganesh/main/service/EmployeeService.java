package com.ganesh.main.service;

import java.util.List;

import com.ganesh.main.entity.Employee;

public interface EmployeeService {

	List<Employee> getEmployeesByNameAndAge(String name,Long age);
	
	Employee findById(Long id);
	List<Employee > findByAge(Long age);
	List<Employee> getEmployeesByNameOrLocation(String name,String location);
	Integer  deleteEmployeeByName(String name);

	Employee saveEmployee(Employee employee);
}
