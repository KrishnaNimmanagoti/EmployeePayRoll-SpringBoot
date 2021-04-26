package com.bridgelabz.employeepayrollapp.service;

import java.util.List;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;

public interface IEmployeePayRollService {
	
	List<Employee> getEmpoloyees();    
	
	Employee addEmpoloyee(EmployeeDTO employee);

}
