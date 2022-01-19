package com.bridgelabz.employeepayrollapp.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.ToString;

/**
 * EmployeePayrollDTO : Details of emloyees
 * @author sayali
 *
 */
@Data
public @ToString class EmployeePayrollDTO {
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\$]{2,}$",message = "Employee name Invalid")
	public String name;
	
	@Min(value = 500, message = "minimun wage should be 500")
	public long salary;
	
	@Pattern(regexp = "male|female", message = "Gender needs to either male or female")
	public String gender;
	
	@JsonFormat(pattern = "dd MM yyyy")
	@NotNull(message = "Startdate should not be empty")
	@PastOrPresent(message = "start date should be Past or Today's date")
	public LocalDate startDate;
	
	@NotBlank(message = "note can not be null")
	public String note;
	
	@NotBlank(message = "profilePic can not be null")
	public String profilePic;
	
	@NotNull(message = "departments should not be null")
	public List<String> departments;

	
}
