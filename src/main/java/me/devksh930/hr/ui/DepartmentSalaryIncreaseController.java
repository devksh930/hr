package me.devksh930.hr.ui;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import me.devksh930.hr.application.service.DepartmentSalaryIncreaseService;
import me.devksh930.hr.dto.command.DepartmentSalaryIncreaseCommand;
import me.devksh930.hr.dto.request.DepartmentSalaryIncreaseRequest;
import me.devksh930.hr.dto.response.DepartmentSalaryIncreaseResponse;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentSalaryIncreaseController {
	private final DepartmentSalaryIncreaseService departmentSalaryIncreaseService;

	@PatchMapping("/{departmentId}/salary-increase")
	public ResponseEntity<List<DepartmentSalaryIncreaseResponse>> increaseDepartmentSalary(
		@PathVariable final Integer departmentId,
		@RequestBody final DepartmentSalaryIncreaseRequest request
	) {
		final List<DepartmentSalaryIncreaseResponse> departmentSalaryIncreaseResponses = departmentSalaryIncreaseService.departmentIncreaseSalary(new DepartmentSalaryIncreaseCommand(
			departmentId,
			request.percentage()
		));
		return ResponseEntity.ok(departmentSalaryIncreaseResponses);
	}
}
