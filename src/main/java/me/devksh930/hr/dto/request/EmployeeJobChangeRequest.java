package me.devksh930.hr.dto.request;

import java.time.LocalDate;

public record EmployeeJobChangeRequest(
	String jobId,
	LocalDate startDate,
	LocalDate endDate
) {
}
