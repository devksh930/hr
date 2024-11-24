package me.devksh930.hr.ui;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import me.devksh930.hr.application.service.DepartmentQueryService;
import me.devksh930.hr.dto.response.DepartmentResponse;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentQueryController {
	private final DepartmentQueryService departmentQueryService;

	@GetMapping
	public ResponseEntity<PageImpl<DepartmentResponse>> queryDepartment(
		@RequestParam final int page,
		@RequestParam final int size
	) {
		return ResponseEntity.ok(departmentQueryService.queryDepartmentWithPaging(PageRequest.of(
			page,
			size
		)));
	}
}
