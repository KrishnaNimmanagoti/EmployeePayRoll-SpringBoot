package com.bridgelabz.employeepayrollapp.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public ResponseEntity<ResponseDTO> addEmployee(@Valid @RequestBody EmployeeDTO employee, BindingResult bindingResult) {
        
		if (bindingResult.hasErrors()) {
			List<String> collect = bindingResult.getAllErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.toList());

            return new ResponseEntity<ResponseDTO>(
                    new ResponseDTO(collect,"validation error" ),
                    HttpStatus.BAD_REQUEST);
		}
		
		Employee emp = employeePayRollService.addEmpoloyee(employee);
        return new ResponseEntity<ResponseDTO>(
                new ResponseDTO(emp, "Employee created successfully"),
                HttpStatus.CREATED);
    }
	
	@GetMapping
    public ResponseEntity<ResponseDTO> getEmployees() {
        List<Employee> empoloyees = employeePayRollService.getEmpoloyees();
        return new ResponseEntity<ResponseDTO>(
                new ResponseDTO(empoloyees, "Employee fetched successfully"),
                HttpStatus.OK);
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseDTO> getEmployeeById(@PathVariable("id") int employeeId) {
		Employee employee = employeePayRollService.getEmployeeById(employeeId);
		return new ResponseEntity<ResponseDTO>(
                new ResponseDTO(employee, "Employee fetched successfully"),
                HttpStatus.OK);
		
	}

}
