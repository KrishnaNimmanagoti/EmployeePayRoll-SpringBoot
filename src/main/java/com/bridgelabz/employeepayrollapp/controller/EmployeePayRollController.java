package com.bridgelabz.employeepayrollapp.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.service.IEmployeePayRollService;

/**
 * connection with server
 * 
 * @author Krishna
 *
 */
@RestController
@RequestMapping("/employeepayroll")

public class EmployeePayRollController {

	@Autowired
	private IEmployeePayRollService employeePayRollService;

	/**
	 * method add new employee
	 * 
	 * @param employee
	 * @return employee details
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping
	public ResponseEntity<ResponseDTO> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
		Employee employee = employeePayRollService.addEmpoloyee(employeeDTO);
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(employee, "Employee created successfully"),
				HttpStatus.CREATED);
	}

	/**
	 * method to get list of employees
	 * 
	 * @return list of employee
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping
	public List<Employee> getEmployeesList() {
		List<Employee> empoloyees = employeePayRollService.getEmpoloyeesList();
		return empoloyees;

//				new ResponseEntity<ResponseDTO>(new ResponseDTO(employees, "Employee fetched successfully"),
//				HttpStatus.OK);
	}

	/**
	 * method to find employee by id
	 * 
	 * @param employeeId
	 * @return employee data
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{id}")
	public ResponseEntity<ResponseDTO> getEmployeeById(@PathVariable("id") int employeeId) {
		Employee employee = employeePayRollService.getEmployeeById(employeeId);
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(employee, "Employee fetched successfully"),
				HttpStatus.OK);
	}

	/**
	 * method to update employee details by id
	 * 
	 * @param employeeId
	 * @param employeeDTO
	 * @return employee data
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/{id}")
	public ResponseEntity<ResponseDTO> updateEmployeeById(@Valid @RequestBody EmployeeDTO employeeDTO,
			@PathVariable("id") int employeeId) {
		Employee employee = employeePayRollService.updateEmployeeById(employeeDTO, employeeId);
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(employee, "Employee Updated successfully"),
				HttpStatus.OK);
	}

	/**
	 * method to delete employee from DataBase
	 * 
	 * @param employeeId
	 * @return employee data
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseDTO> deleteEmployeeById(@PathVariable("id") int employeeId) {
		Optional<Employee> employee = employeePayRollService.deleteEmployeeById(employeeId);
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(employee, "Employee Deleted successfully"),
				HttpStatus.OK);
	}
}
