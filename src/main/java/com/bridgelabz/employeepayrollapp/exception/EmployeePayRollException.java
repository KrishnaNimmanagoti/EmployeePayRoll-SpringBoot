package com.bridgelabz.employeepayrollapp.exception;

public class EmployeePayRollException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public final exceptionType type;

	public EmployeePayRollException(exceptionType type, String message) {
		super(message);
		this.type = type;
	}

	public enum exceptionType {
		EMPLOYEE_NOT_FOUND,
	};

}
