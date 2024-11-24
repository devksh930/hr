package me.devksh930.hr.common.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import lombok.extern.slf4j.Slf4j;
import me.devksh930.hr.exception.ExternalApiException;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(
		MethodArgumentNotValidException e
	) {
		log.error(
			"handleMethodArgumentNotValidException",
			e
		);
		final ErrorResponse response = ErrorResponse.of(
			ErrorCode.INVALID_INPUT_VALUE,
			e.getBindingResult()
		);
		return ResponseEntity.status(response.getStatus()).body(response);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException(
		HttpMessageNotReadableException e
	) {
		log.error(
			"handleHttpMessageNotReadableException",
			e
		);
		final ErrorResponse response = ErrorResponse.of(ErrorCode.INVALID_TYPE_VALUE);
		return ResponseEntity.status(response.getStatus()).body(response);
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	protected ResponseEntity<ErrorResponse> handleMissingRequestHeaderExceptionException(
		MissingServletRequestParameterException ex
	) {
		log.error(
			"handleMissingServletRequestParameterException",
			ex
		);
		final ErrorResponse response = ErrorResponse.of(ErrorCode.MISSING_REQUEST_PARAMETER_ERROR);
		return new ResponseEntity<>(
			response,
			HttpStatus.BAD_REQUEST
		);
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	protected ResponseEntity<ErrorResponse> handleHttpRequestMethodNotSupportedException(
		HttpRequestMethodNotSupportedException e
	) {

		log.error(
			"handleHttpRequestMethodNotSupportedException",
			e
		);
		final ErrorResponse response = ErrorResponse.of(ErrorCode.METHOD_NOT_ALLOWED);
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(response);
	}

	@ExceptionHandler(HandlerMethodValidationException.class)
	protected ResponseEntity<ErrorResponse> handleHandlerMethodValidationException(
		HandlerMethodValidationException e
	) {
		log.error(
			"handleHttpRequestMethodNotSupportedException",
			e
		);
		final ErrorResponse response = ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	@ExceptionHandler(ExternalApiException.class)
	protected ResponseEntity<ErrorResponse> handleBadCredentialsException(
		ExternalApiException ex
	) {
		log.error(
			"ExternalApiException :: ",
			ex
		);
		final ErrorResponse response = ErrorResponse.of(ex.getErrorCode());
		return ResponseEntity.status(response.getStatus()).body(response);
	}

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<ErrorResponse> handleException(Exception e) {
		log.error(
			"handleException",
			e
		);
		final ErrorResponse response = ErrorResponse.of(
			ErrorCode.INTERNAL_SERVER_ERROR,
			"잠시후 다시 시도해 주세요"
		);
		return ResponseEntity.status(response.getStatus()).body(response);
	}

}
