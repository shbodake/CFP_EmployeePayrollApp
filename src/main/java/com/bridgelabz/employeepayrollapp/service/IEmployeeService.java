package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.model.Employees;

public interface IEmployeeService {
	Employees getDetails(Long empId);
	Employees addDetails(Employees employee);
	Employees editDetails(Employees employee);
	Employees deleteEmpId(Long empId);
}
