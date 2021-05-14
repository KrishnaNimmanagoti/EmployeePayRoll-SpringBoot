package com.bridgelabz.employeepayrollapp.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String name;
	private double salary;
	private LocalDate startDate;
	private String gender;

	@ElementCollection
	@CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "id"))
	@Column(name = "department")
	private List<String> departments;
	private String notes;
	private String profileImage;

	public Employee(EmployeeDTO employeeDTO) {
		this.name = employeeDTO.getName();
		this.salary = employeeDTO.getSalary();
		this.startDate = employeeDTO.getStartDate();
		this.gender = employeeDTO.getGender();
		this.departments = employeeDTO.getDepartments();
		this.notes = employeeDTO.getNotes();
		this.profileImage = employeeDTO.getProfileImage();
	}
}
