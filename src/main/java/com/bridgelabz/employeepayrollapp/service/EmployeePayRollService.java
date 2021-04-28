package com.bridgelabz.employeepayrollapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeePayRollException;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.repository.IEmployeePayRollRepo;

@Service
public class EmployeePayRollService implements IEmployeePayRollService {

	@Autowired
	private IEmployeePayRollRepo employeePayrollRepo;

	@Override
	public List<Employee> getEmpoloyees() {
		return employeePayrollRepo.findAll();
	}

	@Override
	public Employee addEmpoloyee(EmployeeDTO employee) {
		Employee newEmp = new Employee(employee);
        return this.employeePayrollRepo.save(newEmp);
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		return this.employeePayrollRepo.findById(employeeId)
                .orElseThrow(() ->
                        new EmployeePayRollException(
                        		EmployeePayRollException.exceptionType.EMPLOYEE_NOT_FOUND,
                                "Employee is not exist")
                );
	}

	@Override
	public Employee updateEmployeeById(EmployeeDTO employeeDTO, int employeeId) {
		
		return employeePayrollRepo.findById(employeeId)
				.map(employee -> {
					employee.setName(employeeDTO.getName());
					employee.setEmail(employeeDTO.getEmail());
					employee.setPhone(employeeDTO.getPhone());
					employee.setAddress(employeeDTO.getAddress());
					employee.setSalary(employeeDTO.getSalary());
					employee.setJoinDate(employeeDTO.getJoinDate());
					return this.employeePayrollRepo.save(employee);
				})
				.orElseGet(() -> {
					return this.addEmpoloyee(employeeDTO);
				});
	}

	@Override
	public Optional<Employee> deleteEmployeeById(int employeeId) {
		Optional<Employee> employee = employeePayrollRepo.findById(employeeId);
		employeePayrollRepo.deleteById(employeeId);
		return employee;
	}
	
	
}
