package com.bridgelabz.employeepayrollapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exceptions.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.model.User;
import com.bridgelabz.employeepayrollapp.repository.IEmployeePayrollRepository;
import com.bridgelabz.employeepayrollapp.repository.IUserRepository;
import com.bridgelabz.employeepayrollapp.utility.TokenUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService {

	@Autowired
	private IEmployeePayrollRepository employeeRepository;

	@Autowired
	private IUserRepository userRepository;

	@Autowired
    TokenUtil tokenUtil;

	/**
	 * @param : usernamr password
	 * @return : token
	 * 
	 */
	@Override
	public String generateToken(User user) {
		Optional<User> userOptional = userRepository
				.findById(userRepository.getUserDetails(user.getUserName(), user.getPassword()).getId());
		if (userOptional.isPresent()) {

			return tokenUtil.generateToken(user.getUserName());
		} else {
			throw new EmployeePayrollException("User Not Found");
		}
	}
	
	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<EmployeePayrollData> getEmployeePayrollData(String token) {
		if (tokenUtil.isValidToken(token)) {
			return employeeRepository.findAll();
		} else
			throw new EmployeePayrollException("Not Valid Token");
	}
	
	/**
	 * Using Get method to get the employee by id
	 * 
	 * @param empId : Employee Id
	 * @return : It will return details of employee
	 */

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empId, String token) {
		if (tokenUtil.isValidToken(token)) {
			return employeeRepository.findById(empId)
					.orElseThrow(() -> new EmployeePayrollException("employee ID Not Found"));
		} else
			throw new EmployeePayrollException("Not Valid Token");
	}
	
	/**
	 * Using post method to add the details
	 * 
	 * @param empPayrollDTO : Employee name and salary , token
	 * @return : employee id, name and salary
	 */

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO , String token) {
		EmployeePayrollData empData = null;
		empData = new EmployeePayrollData(empPayrollDTO);
		log.debug("Employee Data: " + empData.toString());
		return employeeRepository.save(empData);
	}
	
	/**
	 * Using put method to update the details
	 * 
	 * @param empPayrollDTO : Employee name and salary
	 * @return : employee id, name and salary
	 */

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO, String token) {
		EmployeePayrollData empData = null;
		empData = new EmployeePayrollData(empPayrollDTO);
		return employeeRepository.save(empData);

	}
	
	/**
	 * Using delete method to delete the employee details
	 * 
	 * @param empId : Employee id
	 * @return : will return string for deleted id
	 */

	@Override
	public void deleteEmployeePayrollData(int empId, String token) {
		EmployeePayrollData empData = this.getEmployeePayrollDataById(empId, token);
		employeeRepository.delete(empData);

	}

	@Override
	public List<EmployeePayrollData> getEmployeesPayrollDataByDepartment(String department) {
		return employeeRepository.findEmployeesByDepartment(department);
	}
	
	
	
	
}
