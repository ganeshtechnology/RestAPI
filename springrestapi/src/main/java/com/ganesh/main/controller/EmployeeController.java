package com.ganesh.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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

import jakarta.validation.Valid;

@RestController           // Combination of @Controller and @ResponseBody annotation 

public class EmployeeController {
	 
	@Autowired
	private EmployeeService employeeService;
@GetMapping("/employees/{name}/{age}")
public ResponseEntity<List<Employee>> getEmployeesByNameAndAge(@PathVariable String name,@PathVariable Long age ){
	
	return new ResponseEntity<List<Employee>>(employeeService.getEmployeesByNameAndAge(name, age),HttpStatus.OK);
	
	
}
@PostMapping
public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee ){
	return new  ResponseEntity<Employee>(employeeService.saveEmployee(employee),HttpStatus.OK);
	
}
@GetMapping("/employees/{id}")
public ResponseEntity<Employee> getEmployeesByNameAndAge(@PathVariable Long id){
	
	return new ResponseEntity<Employee>(employeeService.findById(id),HttpStatus.OK);

}

@GetMapping("/employees/findbyage")
public ResponseEntity<List<Employee>> getEmployeesByAge(@RequestParam Long age){
	
	return new ResponseEntity<List<Employee>> (employeeService.findByAge(age),HttpStatus.OK);

}


@GetMapping("/employees/{name}/{location}")
public ResponseEntity<List<Employee>> getEmployeesByKeyword(@PathVariable String  name, @PathVariable String location){
	
	return new ResponseEntity<List<Employee>> (employeeService.getEmployeesByNameOrLocation(name, location),HttpStatus.OK);

}

@DeleteMapping("/employees/{name}")
public ResponseEntity<String> deleteByName(@PathVariable String  name){
	
	return new ResponseEntity<String> (employeeService.deleteEmployeeByName(name)+"No. of records deleted",HttpStatus.OK);

}
}