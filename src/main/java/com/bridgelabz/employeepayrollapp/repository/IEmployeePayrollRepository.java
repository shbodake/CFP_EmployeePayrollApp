package com.bridgelabz.employeepayrollapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

public interface IEmployeePayrollRepository extends JpaRepository<EmployeePayrollData, Integer>{

}
