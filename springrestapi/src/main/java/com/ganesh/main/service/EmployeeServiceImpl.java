package com.ganesh.main.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ganesh.main.entity.Employee;
import com.ganesh.main.repository.EmployeeRepository;

@Service 
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getEmployeesByNameAndAge(String name, Long age) {
		return employeeRepository.findByNameAndAge(name, age);
	}

	@Override
	public Employee findById(Long id) {
		return employeeRepository.findById(id).orElseThrow(()-> new IllegalArgumentException());
	}

	@Override
	public List<Employee> findByAge(Long age) {
		return employeeRepository.findByAge(age);
	}

	

	@Override
	public List<Employee> getEmployeesByNameOrLocation(String name, String location) {
		return employeeRepository.getEmployeesByNameAndLocation(name, location);
	}

	@Override
	public Integer  deleteEmployeeByName(String name) {
		return employeeRepository.deleteEmployeeByName(name);
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}

	
	
	
	
	
	}
	


