package com.bridgelabz.employeepayrollapp.model;

import java.time.LocalDate;
import java.util.List;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;

import lombok.Data;
@Data
public class EmployeePayrollData {
	private int employeeId;
	private String name;
	private long salary;
	private String gender;
	private LocalDate startDate;
	private String note;
	private String profilePic;
	private List<String> departments;
	
	public EmployeePayrollData() {}

	public EmployeePayrollData(int empId, EmployeePayrollDTO empPayRollDTO) {
		super();
		this.employeeId = empId;
		this.name = empPayRollDTO.name;
		this.salary = empPayRollDTO.salary;
	}

	public void updateEmployeePayroll(EmployeePayrollDTO empPayRollDTO) {
		this.name = empPayRollDTO.name;
		this.salary = empPayRollDTO.salary;
		this.gender = empPayRollDTO.gender;
		this.note = empPayRollDTO.note;
		this.startDate = empPayRollDTO.startDate;
		this.profilePic = empPayRollDTO.profilePic;
		this.departments = empPayRollDTO.departments;
	}

}
