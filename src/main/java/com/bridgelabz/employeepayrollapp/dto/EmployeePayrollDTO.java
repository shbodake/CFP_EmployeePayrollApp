package com.bridgelabz.employeepayrollapp.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.ToString;

/**
 * EmployeePayrollDTO : Details of emloyees
 * @author sayali
 *
 */
public @ToString class EmployeePayrollDTO {
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\$]{2,}$",message = "Employee name Invalid")
	public String name;
	
	@Min(value = 500, message = "minimun wage should be 500")
	public long salary;
	
	@Pattern(regexp = "male|female", message = "Gender needs to either male or female")
	public String gender;
	
	@JsonFormat(pattern = "dd MMM yyyy")
	@PastOrPresent(message = "start date should be Past or Today's date")
	public LocalDate startDate;
	
	@NotEmpty(message = "note can not be null")
	public String note;
	
	@NotEmpty(message = "profilePic can not be null")
	public String profilePic;
	
	@NotEmpty(message = "departments should not be null")
	public List<String> departments;

	
}
