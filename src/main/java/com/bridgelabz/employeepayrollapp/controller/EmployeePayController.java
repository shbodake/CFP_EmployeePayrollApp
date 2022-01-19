package com.bridgelabz.employeepayrollapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.model.User;
import com.bridgelabz.employeepayrollapp.services.IEmployeePayrollService;

@RestController
@RequestMapping("/employeepayroll")
public class EmployeePayController {
	
	@Autowired
	private IEmployeePayrollService employeePayrollService;
	
	/**
	 * @param user
	 * @return user creation string
	 */
	
	@PostMapping("/userregister")
	public ResponseEntity<ResponseDTO> generateUser(@RequestBody User user) {
		User userDetailUser = employeePayrollService.createUser(user);
		ResponseDTO responseDTO = new ResponseDTO("Create Call Success ", userDetailUser, HttpStatus.CREATED);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);
	}

	/**
	 * @param username password
	 * @return token
	 */

	@GetMapping("/token")
	public ResponseEntity<ResponseDTO> loginUser(@RequestBody User user) {
		String userDetailUser = employeePayrollService.generateToken(user);
		ResponseDTO responseDTO = new ResponseDTO("Create Call Success ", userDetailUser, HttpStatus.OK);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);

	}
	
	/**
	 * Call methdod to get employee details
	 * @return : Employee details
	 */
	@RequestMapping(value = {"/get" })
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@RequestHeader String token) {
			List<EmployeePayrollData> empDataList = null;
			empDataList = employeePayrollService.getEmployeePayrollData(token);
			ResponseDTO respDTO = new ResponseDTO("Get Call Success", empDataList, HttpStatus.ACCEPTED);
			return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
		}


	/**
	 * Call get method 
	 * @param empId : Employee id
	 * @return : Employee details with id
	 */
	@GetMapping("/get/{empId}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId , @RequestHeader String token) {
		EmployeePayrollData employeePayrollData = employeePayrollService.getEmployeePayrollDataById(empId, token);
		ResponseDTO respDTO = new ResponseDTO("Get call for ID Successful:", employeePayrollData, HttpStatus.ACCEPTED);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * Call post method
	 * @param empPayrollDTO : name, salary
	 * @return : Employee details with id
	 */
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO empPayrollDTO , @RequestHeader String token) {
		EmployeePayrollData employeePayrollData = employeePayrollService.createEmployeePayrollData(empPayrollDTO, token);
		ResponseDTO respDTO = new ResponseDTO("Create Employee PayrollData:", employeePayrollData, HttpStatus.ACCEPTED);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * Call put method
	 * @param empId : Employee id
	 * @param empPayrollDTO : name, salary
	 * @return : Employee details
	 */
	@PutMapping("/update/{empId}")
	public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@Valid @PathVariable("empId") int empId,
			@RequestBody EmployeePayrollDTO empPayrollDTO , @RequestHeader String token) {
		EmployeePayrollData empData =employeePayrollService.updateEmployeePayrollData(empId, empPayrollDTO, token);
		ResponseDTO respDTO = new ResponseDTO("Updated Employee PayrollData Successfully:", empData,HttpStatus.ACCEPTED);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);

	}

	/**
	 * Call delete method
	 * @param empId : Employee id
	 * @return : Deletion status with id
	 */
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId , @RequestHeader String token) {
		employeePayrollService.deleteEmployeePayrollData(empId, token);
		ResponseDTO respDTO = new ResponseDTO("Deleted Successful,Deleted Id:", +empId, HttpStatus.ACCEPTED);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	/**
	 * getting emp info by dept.
	 * @param department
	 * @return : emp details by departments and httpStatus
	 */
	@GetMapping("/department/{department}")
	public ResponseEntity<ResponseDTO> getEmployeeByDepartment(@PathVariable String department) {

		List<EmployeePayrollData> employeeList = null;
		employeeList = employeePayrollService.getEmployeesPayrollDataByDepartment(department);
		ResponseDTO response = new ResponseDTO("Get Call for Department Successful", employeeList, HttpStatus.ACCEPTED);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}
	
}
