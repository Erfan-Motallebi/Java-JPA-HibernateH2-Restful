package com.springboot.jpa.h2.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.springboot.jpa.h2.entity.Department;
import com.springboot.jpa.h2.repository.DepartmentRepository;

@SpringBootTest
class DepartmentServiceTest {

	@Autowired
	DepartmentService departmentService;

	@MockBean
	DepartmentRepository departmentRepository;

	@BeforeEach
	public void setUp() throws Exception {
		Department department = Department.builder().departmentId(1L).departmentName("Engineering")
				.departmentNumbers(10L).departmentSection("Software Engineering").departmentCode("EN-02").build();
		
		Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase(department.getDepartmentName())).thenReturn(department);
	}

	@Test
	@DisplayName(value = "Get a specific department by name")
	public void getTheDeparment_usingDepartmentName() {
		String departmentName = "Engineering";
		Department foundDep = departmentService.findDepartmentByName(departmentName);

		assertEquals(departmentName, foundDep.getDepartmentName());
	}

}
