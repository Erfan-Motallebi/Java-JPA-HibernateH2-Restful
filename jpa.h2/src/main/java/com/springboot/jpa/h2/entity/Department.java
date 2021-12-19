package com.springboot.jpa.h2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long departmentId;
	
	@Column(name = "department_name")
	private String departmentName;
	
	@Column(name = "department_section")
	private String departmentSection;

	@Column(name = "department_numbers")
	private Long departmentNumbers;

	@Column(name = "department_Code")
	private String departmentCode;
	
	Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(Long departmentId, String departmentName, String departmentSection, Long departmentNumbers, String departmentCode) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.departmentSection = departmentSection;
		this.departmentNumbers = departmentNumbers;
		this.departmentCode = departmentCode;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentSection() {
		return departmentSection;
	}

	public void setDepartmentSection(String departmentSection) {
		this.departmentSection = departmentSection;
	}

	public Long getDepartmentNumbers() {
		return departmentNumbers;
	}

	public void setDepartmentNumbers(Long departmentNumbers) {
		this.departmentNumbers = departmentNumbers;
	}

	
	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName
				+ ", departmentSection=" + departmentSection + ", departmentNumbers=" + departmentNumbers
				+ ", departmentCode=" + departmentCode + "]";
	}
		
	

}
