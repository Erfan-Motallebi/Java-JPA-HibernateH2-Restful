package com.springboot.jpa.h2.service;

import java.util.List;

import com.springboot.jpa.h2.entity.Department;

public interface DepartmentService {
	Department saveDepartment(Department department);

	List<Department> extractAllDepartment();
}
