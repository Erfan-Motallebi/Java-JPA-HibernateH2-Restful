package com.springboot.jpa.h2.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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

		Department department2 = Department.builder().departmentId(2L).departmentName("Marketing")
				.departmentNumbers(50L).departmentSection("Software Marketing").departmentCode("MT-02").build();

		
		List<Department> departments = new ArrayList<Department>();
		departments.add(department);
		departments.add(department2);

		Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase(department.getDepartmentName()))
				.thenReturn(department);
		Mockito.when(departmentRepository.findAll()).thenReturn(departments);
		Mockito.when(departmentRepository.findById(department.getDepartmentId()).get()).thenReturn(department);
	}

	@Test
	@DisplayName(value = "Get a specific department by name")
	@Disabled
	public void getTheDeparment_usingDepartmentName() {
		String departmentName = "Engineering";
		Department foundDep = departmentService.findDepartmentByName(departmentName);

		assertEquals(departmentName, foundDep.getDepartmentName());
	}

	@Test
	@DisplayName(value = "get All departments")
	@Disabled
	public void getAllDepartmentsWhenSatisfied() {

		Department department1 = Department.builder().departmentId(1L).departmentName("Engineering")
				.departmentNumbers(10L).departmentSection("Software Engineering").departmentCode("EN-02").build();

		Department department2 = Department.builder().departmentId(2L).departmentName("Marketing")
				.departmentNumbers(50L).departmentSection("Software Marketing").departmentCode("MT-02").build();
		List<Department> allDepartmentsExpected = new ArrayList<Department>();
		allDepartmentsExpected.add(department1);
		allDepartmentsExpected.add(department2);

		List<Department> allDepartmentsActual = departmentService.extractAllDepartments();

		assertEquals(allDepartmentsExpected.size(), allDepartmentsActual.size());
		assertEquals(allDepartmentsExpected, allDepartmentsActual);
	}

}
