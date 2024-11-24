package me.devksh930.hr.dto.command;

import java.time.LocalDate;

public record EmployeeJobChangeCommand(
	Integer employeeId,
	String jobId,
	LocalDate startDate,
	LocalDate endDate
) {

}
