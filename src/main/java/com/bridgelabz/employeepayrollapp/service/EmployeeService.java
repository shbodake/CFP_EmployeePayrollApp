package com.bridgelabz.employeepayrollapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.model.Employees;
import com.bridgelabz.employeepayrollapp.repository.IEmployeePayrollRepository;

@Service
public class EmployeeService implements IEmployeeService{
	@Autowired
	private IEmployeePayrollRepository employeerepository;
	

	/**
	 * Call get method to get details from table
	 * @param empId
	 * @return
	 */
	@Override
	public Employees getDetails(Long empId) {
		return employeerepository.findById(empId).get();
	}
	
	/**
	 * Call post method to add details in the table
	 * @param employee
	 * @return
	 */
	@Override
	public Employees addDetails(Employees employee) {
		return employeerepository.save(employee);
	}
	
	/**
	 * Call put method to edit details in the table
	 * @param employee
	 * @return
	 */
	@Override
	public Employees editDetails(Employees employee) {
		return employeerepository.save(employee);
	}
	
	/**
	 * Call delete method to remove details from table
	 * @param empId
	 * @return
	 */
	@Override
	public Employees deleteEmpId(Long empId) {
		Optional<Employees> isPresent = employeerepository.findById(empId);
		if(isPresent.isPresent()) {
			employeerepository.delete(isPresent.get());
			return isPresent.get();
		}else
			return null;
	}
	
}
