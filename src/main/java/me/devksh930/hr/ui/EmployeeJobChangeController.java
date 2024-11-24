package me.devksh930.hr.ui;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import me.devksh930.hr.application.service.EmployeeJobChangeService;
import me.devksh930.hr.dto.command.EmployeeJobChangeCommand;
import me.devksh930.hr.dto.request.EmployeeJobChangeRequest;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeJobChangeController {
	private final EmployeeJobChangeService employeeJobChangeService;

	@PatchMapping("/{employeeId}/job")
	public ResponseEntity<Void> employeeJobChange(
		@PathVariable final Integer employeeId,
		@Validated @RequestBody EmployeeJobChangeRequest request
	) {
		employeeJobChangeService.changeJob(new EmployeeJobChangeCommand(
			employeeId,
			request.jobId(),
			request.startDate(),
			request.endDate()
		));
		return ResponseEntity.noContent().build();
	}
}
