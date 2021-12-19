package com.springboot.jpa.h2.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
}
