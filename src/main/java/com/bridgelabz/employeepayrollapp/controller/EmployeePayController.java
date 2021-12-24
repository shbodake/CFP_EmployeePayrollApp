package com.bridgelabz.employeepayrollapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

@RestController
@RequestMapping("/employeepayroll")
public class EmployeePayController {
	/**
	 * Call methdod to get employee details
	 * @return : Employee details
	 */
	@RequestMapping(value = { "", "/", "/get" })
	public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
		EmployeePayrollData employeePayrollData = null;
		employeePayrollData = new EmployeePayrollData(1, new EmployeePayrollDTO("Sayali", 33000));
		ResponseDTO respDTO = new ResponseDTO("Get call Successful:", employeePayrollData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * Call get method 
	 * @param empId : Employee id
	 * @return : Employee details with id
	 */
	@GetMapping("/get/{empId}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {
		EmployeePayrollData employeePayrollData = null;
		employeePayrollData = new EmployeePayrollData(empId, new EmployeePayrollDTO("Lokesh",95000));
		ResponseDTO respDTO = new ResponseDTO("Get call for ID Successful:", employeePayrollData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * Call post method
	 * @param empPayrollDTO : name, salary
	 * @return : Employee details with id
	 */
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData employeePayrollData = null;
		employeePayrollData = new EmployeePayrollData(1, empPayrollDTO);
		ResponseDTO respDTO = new ResponseDTO("Create Employee PayrollData:", employeePayrollData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * Call put method
	 * @param empId : Employee id
	 * @param empPayrollDTO : name, salary
	 * @return :
	 */
	@PutMapping("/update/{empId}")
	public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") int empId,
			@RequestBody EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData employeePayrollData = null;
		employeePayrollData = new EmployeePayrollData(empId, empPayrollDTO);
		ResponseDTO respDTO = new ResponseDTO("Update Employee PayrollData Successful:", employeePayrollData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);

	}

	/**
	 * Call delete method
	 * @param empId : Employee id
	 * @return : Deletion status with id
	 */
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
		ResponseDTO respDTO = new ResponseDTO("Deleted Successful,Deleted Id:", + empId);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
}
