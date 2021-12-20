package com.springboot.jpa.h2.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jpa.h2.entity.Department;
import com.springboot.jpa.h2.entity.EntitySuccessClass;
import com.springboot.jpa.h2.error.DepartmentNotFoundException;
import com.springboot.jpa.h2.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	private final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(DepartmentController.class);
	
	@PostMapping(path = "/departments")
	public ResponseEntity<Department> postDepartment(@Valid @RequestBody Department department) {
			LOGGER.info("Saved the department successfully");
			Department newDepartment =  departmentService.saveDepartment(department);
			return ResponseEntity.status(HttpStatus.CREATED).body(newDepartment);
	}
	
	@GetMapping(path = "/departments")
	public List<Department> getDepartments() {
		return departmentService.extractAllDepartment();
	}
	
	@PostMapping(path = "/departments/{id}")
	public Department getSpecificDepartment(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
		return departmentService.findDepartmentById(departmentId);
	}
	
	
	@PutMapping(path = "/departments/{id}")
	public Department updateSpecificDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department) throws DepartmentNotFoundException{
		try {
			return departmentService.updateDepartmentById(departmentId, department);
		} catch (Exception e) {
			throw new DepartmentNotFoundException("Failed to update the specific DepartmentID");
		}
	}
	
	@DeleteMapping(path = "/departments/{id}")
	public ResponseEntity<EntitySuccessClass> deleteSpecificDepartment(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
		departmentService.deleteDepartmentIdBy(departmentId);
		EntitySuccessClass successMessage = new EntitySuccessClass(HttpStatus.OK, "Successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(successMessage); 
	}
	
	@GetMapping(path = "/departments/name/{name}")
	public Department findDepartmentBySpecificName(@PathVariable("name") String departmentName) {
		return departmentService.findDepartmentByName(departmentName);
	}
	
}
