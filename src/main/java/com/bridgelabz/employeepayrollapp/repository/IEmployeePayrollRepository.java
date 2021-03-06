package com.bridgelabz.employeepayrollapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

public interface IEmployeePayrollRepository extends JpaRepository<EmployeePayrollData, Integer>{

	@Query(value = "select * from employeepayroll_db,employee_department where employee_id=id and department= :department", nativeQuery = true)
    List<EmployeePayrollData> findEmployeesByDepartment(String department);

}
