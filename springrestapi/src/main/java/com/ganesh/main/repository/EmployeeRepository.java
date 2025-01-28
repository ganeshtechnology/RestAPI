package com.ganesh.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ganesh.main.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	
List<Employee> findByNameAndAge(String name,Long age);

List<Employee> findByAge(Long age);
@Transactional
@Modifying
@Query("DELETE FROM Employee WHERE name= :name")
Integer  deleteEmployeeByName(String name);

@Query("FROM Employee WHERE name= :name OR location=:location")
List<Employee> getEmployeesByNameAndLocation(String name, String location);



}
