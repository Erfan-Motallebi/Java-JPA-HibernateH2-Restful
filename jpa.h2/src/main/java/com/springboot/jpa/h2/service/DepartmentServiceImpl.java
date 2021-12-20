package com.springboot.jpa.h2.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.jpa.h2.entity.Department;
import com.springboot.jpa.h2.error.DepartmentNotFoundException;
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
		return departmentRepository.findAll();
	}

	@Override
	public Department findDepartmentById(Long departmentId) throws DepartmentNotFoundException {
		
		Optional<Department> department = departmentRepository.findById(departmentId);
		
		if(!department.isPresent()) {
			throw new DepartmentNotFoundException("Department Not Found");
		}
		return department.get();
	}

	@Override

	public Department updateDepartmentById(Long departmentId, Department department) {
		Department depDB = departmentRepository.findById(departmentId).get();

		if (Objects.nonNull(depDB.getDepartmentName()) && (depDB.getDepartmentName() != "")) {
			depDB.setDepartmentName(department.getDepartmentName());
		}
		if (Objects.nonNull(depDB.getDepartmentCode()) && (depDB.getDepartmentCode() != "")) {
			depDB.setDepartmentCode(department.getDepartmentCode());
		}
		if (Objects.nonNull(depDB.getDepartmentNumbers()) && (depDB.getDepartmentNumbers() != 0)) {
			depDB.setDepartmentNumbers(department.getDepartmentNumbers());
		}
		if (Objects.nonNull(depDB.getDepartmentSection()) && (depDB.getDepartmentSection() != "")) {
			depDB.setDepartmentSection(department.getDepartmentSection());
		}
		
		return departmentRepository.save(depDB);

	public void deleteDepartmentById(Long departmentId) {
		// TODO Auto-generated method stub
		departmentRepository.deleteById(departmentId);

	}

	@Override
	public void deleteDepartmentIdBy(Long departmentId) {
		departmentRepository.deleteById(departmentId);
	}

	@Override
	public Department findDepartmentByName(String departmentName) {
		return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
	}


}
