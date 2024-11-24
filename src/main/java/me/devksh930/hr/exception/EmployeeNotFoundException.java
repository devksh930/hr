package me.devksh930.hr.exception;

import me.devksh930.hr.common.error.ErrorCode;

public class EmployeeNotFoundException extends ResourceNotFoundException {
	public EmployeeNotFoundException() {
		super(ErrorCode.ENTITY_NOT_FOUND);
	}

}
