package me.devksh930.hr.domain.model;

import java.time.LocalDate;

public record EmployeeJobHistoryQuery(
	Integer employeeId,
	LocalDate startDate,
	LocalDate endDate,
	String jobId,
	String jobTitle,
	Integer departmentId,
	String departmentName
) {
}
