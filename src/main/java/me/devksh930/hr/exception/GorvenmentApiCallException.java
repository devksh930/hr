package me.devksh930.hr.exception;

import me.devksh930.hr.common.error.ErrorCode;

public class GorvenmentApiCallException extends ExternalApiException {
	public GorvenmentApiCallException() {
		super(ErrorCode.GOVERNMENT_EXTERNAL_API_CALL_ERROR);
	}
}
