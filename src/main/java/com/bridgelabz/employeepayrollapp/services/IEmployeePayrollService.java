package com.bridgelabz.employeepayrollapp.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.model.User;

public interface IEmployeePayrollService {
	
	List<EmployeePayrollData> getEmployeesPayrollDataByDepartment(String department);

	List<EmployeePayrollData> getEmployeePayrollData(String token);

	EmployeePayrollData getEmployeePayrollDataById(int empId, String token);

	EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO, String token);

	void deleteEmployeePayrollData(int empId, String token);

	User createUser(User user);

	String generateToken(User user);

	EmployeePayrollData createEmployeePayrollData(@Valid EmployeePayrollDTO empPayrollDTO, String token);
}
