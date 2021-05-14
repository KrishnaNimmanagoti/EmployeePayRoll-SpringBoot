package com.bridgelabz.employeepayrollapp.dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class EmployeeDTO {

	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name is Invalid")
	@NotEmpty(message = "Please enter name")
	private String name;

	@NotNull
	@Min(value = 500, message = "Minimum salary should be more than 500")
	private double salary;

	@JsonFormat(pattern = "dd MMM yyyy")
	@NotNull(message = "startDate should Not be Empty")
	@PastOrPresent(message = "startDate should be past or todays date")
	private LocalDate startDate;

	@Pattern(regexp = "male|female", message = "Gender must be male | female")
	private String gender;

	@NotBlank(message = "profileImage should not be blank")
	private String profileImage;

	private String notes;

	@NotNull
	private List<String> departments;

}
