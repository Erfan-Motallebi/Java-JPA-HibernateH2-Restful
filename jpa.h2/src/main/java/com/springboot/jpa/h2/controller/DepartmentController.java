package com.springboot.jpa.h2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jpa.h2.entity.Department;
import com.springboot.jpa.h2.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping(path = "/departments")
	public Department postDepartment(@RequestBody Department department) {
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping(path = "/departments")
	public List<Department> getDepartments() {
		return departmentService.extractAllDepartment();
	}
}
