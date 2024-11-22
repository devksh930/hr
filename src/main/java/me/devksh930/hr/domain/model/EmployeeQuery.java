package me.devksh930.hr.domain.model;

import java.time.LocalDate;

public record EmployeeQuery(
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
