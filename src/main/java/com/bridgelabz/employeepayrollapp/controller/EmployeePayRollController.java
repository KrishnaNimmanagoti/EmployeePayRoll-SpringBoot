package com.bridgelabz.employeepayrollapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	public ResponseEntity<ResponseDTO> addEmployee(@RequestBody EmployeeDTO employee) {
        Employee emp = employeePayRollService.addEmpoloyee(employee);
        System.out.println(emp + "haiiiiiii");
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

}
