package me.devksh930.hr.ui;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import me.devksh930.hr.application.service.EmployeeInfoChangeService;
import me.devksh930.hr.dto.command.EmployeeInfoChangeCommand;
import me.devksh930.hr.dto.request.EmployeeInfoChangeRequest;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeInfoChangeController {
	private final EmployeeInfoChangeService employeeInfoChangeService;

	@PatchMapping("/{employeeId}")
	public ResponseEntity<Void> employeeInfoChange(
		@PathVariable final Integer employeeId,
		@Validated @RequestBody final EmployeeInfoChangeRequest request
	) {
		employeeInfoChangeService.employeeInfoChange(new EmployeeInfoChangeCommand(
			employeeId,
			request.firstName(),
			request.lastName(),
			request.email(),
			request.phoneNumber(),
			request.hireDate()
		));
		return ResponseEntity.noContent()
			.location(URI.create("/employees/" + employeeId))
			.build();
	}

}
