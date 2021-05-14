package com.bridgelabz.employeepayrollapp.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeePayRollException;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.repository.IEmployeePayRollRepo;

import lombok.extern.slf4j.Slf4j;

/**
 * connection with server
 * 
 * @author Krishna
 *
 */
@Service
@Slf4j
public class EmployeePayRollService implements IEmployeePayRollService {

	@Autowired
	private IEmployeePayRollRepo employeePayrollRepo;

	/**
	 * method to fetch list of employees from DB
	 * 
	 * @return list of employee
	 */
	@Override
	public List<Employee> getEmpoloyeesList() {
		return employeePayrollRepo.findAll();
	}

	/**
	 * method add new employee
	 * 
	 * @param employee
	 * @return employee data
	 */
	@Override
	public Employee addEmpoloyee(EmployeeDTO employee) {
		Employee newEmp = new Employee(employee);
		return this.employeePayrollRepo.save(newEmp);
	}

	/**
	 * method to find employee by id in DB
	 * 
	 * @param employeeId
	 * @return employee data
	 */
	@Override
	public Employee getEmployeeById(int employeeId) {
		return this.employeePayrollRepo.findById(employeeId).orElseThrow(() -> new EmployeePayRollException(
				EmployeePayRollException.exceptionType.EMPLOYEE_NOT_FOUND, "Employee is not exist"));
	}

	/**
	 * method to find employee by id
	 * 
	 * @param employeeId
	 * @return employee data
	 */
	@Override
	public Employee updateEmployeeById(EmployeeDTO employeeDTO, int employeeId) {

		return employeePayrollRepo.findById(employeeId).map(employee -> {
			employee.setName(employeeDTO.getName());
			employee.setSalary(employeeDTO.getSalary());
			employee.setStartDate(employeeDTO.getStartDate());
			employee.setGender(employeeDTO.getGender());
			employee.setDepartments(employeeDTO.getDepartments());
			employee.setNotes(employeeDTO.getNotes());
			employee.setProfileImage(employeeDTO.getProfileImage());
			return this.employeePayrollRepo.save(employee);
		}).orElseGet(() -> {
			return this.addEmpoloyee(employeeDTO);
		});
	}

	@Override
	public Optional<Employee> deleteEmployeeById(int employeeId) {
		Optional<Employee> employee = employeePayrollRepo.findById(employeeId);
		log.warn("Employee Deletion" + employee.get().toString());
		employeePayrollRepo.deleteById(employeeId);
		return employee;
	}
}
