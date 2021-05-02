package com.bridgelabz.employeepayrollapp.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping("/employeepayroll")
public class EmployeePayRollController {

	@Autowired
	private IEmployeePayRollService employeePayRollService;

	@PostMapping
	public ResponseEntity<ResponseDTO> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
		Employee employee = employeePayRollService.addEmpoloyee(employeeDTO);
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(employee, "Employee created successfully"),
				HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<ResponseDTO> getEmployeesList() {
		List<Employee> empoloyees = employeePayRollService.getEmpoloyeesList();
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(empoloyees, "Employee fetched successfully"),
				HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseDTO> getEmployeeById(@PathVariable("id") int employeeId) {
		Employee employee = employeePayRollService.getEmployeeById(employeeId);
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(employee, "Employee fetched successfully"),
				HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ResponseDTO> updateEmployeeById(@Valid @RequestBody EmployeeDTO employeeDTO,
			@PathVariable("id") int employeeId) {
		Employee employee = employeePayRollService.updateEmployeeById(employeeDTO, employeeId);
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(employee, "Employee Updated successfully"),
				HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseDTO> deleteEmployeeById(@PathVariable("id") int employeeId) {
		Optional<Employee> employee = employeePayRollService.deleteEmployeeById(employeeId);
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(employee, "Employee Deleted successfully"),
				HttpStatus.OK);
	}

}
