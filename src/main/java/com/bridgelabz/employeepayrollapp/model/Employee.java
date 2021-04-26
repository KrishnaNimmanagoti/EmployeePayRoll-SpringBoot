package com.bridgelabz.employeepayrollapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;

import lombok.Getter;

@Entity
@Getter
public class Employee {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String email;
    private String phone;

    public Employee() {
    }

    public Employee(EmployeeDTO employee) {
        this.name = employee.getName();
        this.email = employee.getEmail();
        this.phone = employee.getPhone();
    }

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + "]";
	}

   
}
