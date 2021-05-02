package com.bridgelabz.employeepayrollapp.dto;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

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

	@NotEmpty(message = "Please Enter Address")
	private String address;

	@NotNull
	@Min(value = 10000, message = "Minimum salary should be more than 10,000")
	private double salary;

	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date joinDate;

}
