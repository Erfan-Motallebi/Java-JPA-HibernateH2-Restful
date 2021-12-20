package com.springboot.jpa.h2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long departmentId;
	
	@Column(name = "department_name")
	@NotNull(message = "You must add the Department Number")
	private String departmentName;
	
	@Column(name = "department_section")
	private String departmentSection;

	@Min(5)
	@Max(150)
	@Column(name = "department_numbers")
	private Long departmentNumbers;

	@Column(name = "department_Code")
	@NotNull(message = "Enter the department")
	private String departmentCode;	
	

}
