package me.devksh930.hr.exception;

import me.devksh930.hr.common.error.ErrorCode;

public class ResourceNotFoundException extends RuntimeException {
	private ErrorCode errorCode;

	public ResourceNotFoundException(String message, ErrorCode errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public ResourceNotFoundException(ErrorCode errorCode) {
		super(errorCode.getMessage());
		this.errorCode = errorCode;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

}
