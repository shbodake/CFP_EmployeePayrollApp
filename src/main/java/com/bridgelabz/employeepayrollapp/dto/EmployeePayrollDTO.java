package com.bridgelabz.employeepayrollapp.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class EmployeePayrollDTO {
	public long id;
	public String name;
	public long salary;
	
	public EmployeePayrollDTO(long id, String name, long salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeePayrollDTO [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
}
