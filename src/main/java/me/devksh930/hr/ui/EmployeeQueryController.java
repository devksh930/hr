package me.devksh930.hr.ui;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.devksh930.hr.application.service.EmployeeQueryService;
import me.devksh930.hr.dto.response.EmployeeQueryResponse;

@RestController
@RequestMapping("/employees")
@Slf4j
@RequiredArgsConstructor
public class EmployeeQueryController {
	private final EmployeeQueryService employeeQueryService;

	@GetMapping
	public ResponseEntity<PageImpl<EmployeeQueryResponse>> queryEmployee(
		@RequestParam final int page,
		@RequestParam final int size
	) {
		return ResponseEntity.ok(employeeQueryService.queryEmployee(PageRequest.of(
			page,
			size
		)));
	}

}
