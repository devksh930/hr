package me.devksh930.hr.dto.response;

import java.time.LocalDate;

public record EmployeeQueryResponse(
	Integer id,
	String firstName,
	String lastName,
	String email,
	String phoneNumber,
	LocalDate hireDate,
	String departmentId,
	String departmentName,
	String jobId,
	String jobTitle
) {
}
