package com.bridgelabz.employeepayrollapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.employeepayrollapp.model.Employee;

@Repository
public interface IEmployeePayRollRepo extends JpaRepository<Employee, Integer>{

}
