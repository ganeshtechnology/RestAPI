package com.ganesh.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.main.entity.Employee;
import com.ganesh.main.service.EmployeeService;

@RestController           // Combination of @Controller and @ResponseBody annotation 

public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
@GetMapping("/employees")
	public List<Employee> getEmployees() {
	
		return employeeService.getEmployees();
	}
@GetMapping("/employees/{id}")     // PathVariable : We passed the pathvariable as id of employee 
public String getEmployee(@PathVariable Long id) {
	
	return "Feching the employee details for the id " +id;
	
}
@DeleteMapping("/employees")
public String deleteEmployee(@RequestParam Long id) {
	
	return "Deleting the employee detail for the id " +id;
	
}
@PostMapping("/employees")
public String saveEmployee(@RequestBody Employee employee ) {
	
	return "Saving the employee details to database"+employee; 
}

@PutMapping("/employees/{id}")
public Employee updatedEmployee(@PathVariable Long id, @RequestBody Employee employee) {
	
	System.out.println("Updating the employee detail for a id : "+id );
	
	return employee;

}
}