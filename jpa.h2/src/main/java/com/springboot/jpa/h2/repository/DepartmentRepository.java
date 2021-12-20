package com.springboot.jpa.h2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.jpa.h2.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
	Department findByDepartmentName(String departmentName);

	Department findByDepartmentNameIgnoreCase(String departmentName);
}
