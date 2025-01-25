package com.ganesh.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ganesh.main.entity.Employee;

@Service 
public class EmployeeServiceImpl implements EmployeeService {

	private static List<Employee> list = new ArrayList<>();
	static {
		Employee e = new Employee();
		e.setAge(1L);
		e.setDepartment("IT");
		e.setEmail("ganesh@gmail.com");
		e.setLocation("Pune");
		e.setName("Ganesh");
		Employee e2= new Employee();
		e2.setAge(2L);
		e2.setDepartment("IT");
		e2.setEmail("prakash@gmail.com");
		e2.setLocation("Pune");
		e2.setName("Prakash");
		list.add(e2);
		list.add(e);
	}
	@Override
	public List<Employee> getEmployees() {
		
		return list;
	}

}
