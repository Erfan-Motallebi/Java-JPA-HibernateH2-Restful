package com.springboot.jpa.h2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.jpa.h2.entity.Department;
import com.springboot.jpa.h2.repository.DepartmentRepository;


@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> extractAllDepartment() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
	}

}
