package com.bridgelabz.employeepayrollapp.service;

import java.util.List;
import java.util.Optional;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;

public interface IEmployeePayRollService {
	
	List<Employee> getEmpoloyees();    
	
	Employee addEmpoloyee(EmployeeDTO employee);

	Employee getEmployeeById(int employeeId);

	Employee updateEmployeeById(EmployeeDTO employee, int employeeId);

	Optional<Employee> deleteEmployeeById(int employeeId);

}
