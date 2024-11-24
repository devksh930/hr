package me.devksh930.hr.ui;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import me.devksh930.hr.application.service.EmployeeDepartmentChangeService;
import me.devksh930.hr.dto.request.EmployeeDepartmentChangeCommand;
import me.devksh930.hr.dto.request.EmployeeDepartmentChangeRequest;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeDepartmentChangeController {
	private final EmployeeDepartmentChangeService employeeDepartmentChangeService;

	@PatchMapping("/{employeeId}/department")
	public ResponseEntity<Void> employeeDepartmentChange(
		@PathVariable final Integer employeeId,
		@RequestBody final EmployeeDepartmentChangeRequest request
	) {
		employeeDepartmentChangeService.changeDepartment(new EmployeeDepartmentChangeCommand(employeeId,
			request.departmentId()));
		return ResponseEntity.noContent()
			.location(URI.create("/employees/" + employeeId))
			.build();
	}
}
