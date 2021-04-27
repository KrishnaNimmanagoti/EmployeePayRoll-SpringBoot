package com.bridgelabz.employeepayrollapp.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class EmployeeDTO {

	@NotEmpty(message = "Please enter name")
	@Size(min = 3, max = 15)
	private String name;
	
	@Email(message = "Please enter a valid Email")
	private String email;
	
	@Pattern(regexp = "([0-9]{2}[ ]|0)?[6-9][0-9]{9}", message = "Please enter a valid phone")
    private String phone;

}
