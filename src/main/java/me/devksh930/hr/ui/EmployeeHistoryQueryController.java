package me.devksh930.hr.ui;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import me.devksh930.hr.application.service.EmployeeHistoryQueryService;
import me.devksh930.hr.dto.response.EmployeeJobHistoryResponse;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeHistoryQueryController {

	private final EmployeeHistoryQueryService employeeHistoryQueryService;

	@GetMapping("/{employeeId}/job-history")
	public ResponseEntity<PageImpl<EmployeeJobHistoryResponse>> queryEmployeeJobHistory(
		@PathVariable Integer employeeId,
		@RequestParam int page,
		@RequestParam int size
	) {
		return ResponseEntity.ok(employeeHistoryQueryService.queryEmployeeJobHistory(
			employeeId,
			PageRequest.of(
				page,
				size
			)
		));
	}
}
