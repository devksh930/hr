package me.devksh930.hr.dto.response;

import java.time.LocalDate;

public record EmployeeJobHistoryResponse(
	Integer employeeId,
	LocalDate startDate,
	LocalDate endDate,
	String jobId,
	String jobTitle,
	Integer departmentId,
	String departmentName
) {
}
