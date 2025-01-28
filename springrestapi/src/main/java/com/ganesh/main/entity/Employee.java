package com.ganesh.main.entity;



import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name="employee_detail")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)    
	private Long id;
   @NotBlank(message="Name should not be null")
	private String name;
   
	private Long age=0L;
	private String location;
  @Email
	private String email;
  @NotBlank(message="Name should not be null")
	
	private String department;
   @CreationTimestamp
   @Column(name="created_at",nullable=false,updatable=false)
   private Date createAt;
   @UpdateTimestamp
   @Column(name="updated_at")
   private Date updateAt;
}
