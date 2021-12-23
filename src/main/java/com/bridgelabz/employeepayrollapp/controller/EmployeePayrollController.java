package com.bridgelabz.employeepayrollapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.employeepayrollapp.model.Employees;
import com.bridgelabz.employeepayrollapp.service.EmployeeService;
@RestController
@RequestMapping("/emppayroll")
public class EmployeePayrollController {
	/**
	 * @Autowired:Create object of implemented class and inject it
	 */
	@Autowired
	private EmployeeService employeeservice;
	
	/**
	 * Call get method to get details from table
	 * @param empId
	 * @return
	 */
	@GetMapping("/empdetails/{empId}")
	public Employees getDetails(@PathVariable String empId) {
		return employeeservice.getDetails(Long.parseLong(empId));
	}
	
	/**
	 * Call post method to add details in the table
	 * @param employee
	 * @return
	 */
	@PostMapping("/postempDetails")
	public Employees addDetails(@RequestBody Employees employee) {
		return employeeservice.addDetails(employee);
	}
	
	/**
	 * Call put method to edit details in the table
	 * @param employee
	 * @return
	 */
	@PutMapping("/edit")
	public Employees editDetails(@RequestBody Employees employee) {
		return employeeservice.editDetails(employee);
	}
	
	/**
	 * Call delete method to remove details from table
	 * @param empId
	 * @return
	 */
	@DeleteMapping("/empdetails/{empId}")
	public Employees deleteEmpId(@PathVariable String empId) {
		return this.employeeservice.deleteEmpId(Long.parseLong(empId));
	}
}
