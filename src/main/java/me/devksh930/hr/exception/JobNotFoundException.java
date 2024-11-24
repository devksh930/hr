package me.devksh930.hr.exception;

import me.devksh930.hr.common.error.ErrorCode;

public class JobNotFoundException extends ResourceNotFoundException {
	public JobNotFoundException() {
		super(ErrorCode.ENTITY_NOT_FOUND);
	}

}
