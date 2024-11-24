package me.devksh930.hr.exception;

import me.devksh930.hr.common.error.ErrorCode;

public class DepartmentNotFoundException extends ResourceNotFoundException {
	public DepartmentNotFoundException() {
		super(ErrorCode.ENTITY_NOT_FOUND);
	}

}
