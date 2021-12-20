package com.springboot.jpa.h2.service;

import java.util.List;

import com.springboot.jpa.h2.entity.Department;
import com.springboot.jpa.h2.error.DepartmentNotFoundException;

public interface DepartmentService {
	Department saveDepartment(Department department);

	List<Department> extractAllDepartment();
	
	Department findDepartmentById(Long departmentId) throws DepartmentNotFoundException;


	Department updateDepartmentById(Long departmentId, Department department);

	void deleteDepartmentIdBy(Long departmentId) throws DepartmentNotFoundException;

	Department findDepartmentByName(String departmentName);
}
