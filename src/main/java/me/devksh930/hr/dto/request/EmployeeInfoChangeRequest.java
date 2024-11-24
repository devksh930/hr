package me.devksh930.hr.dto.request;

import java.time.LocalDate;

public record EmployeeInfoChangeRequest(
	String firstName,
	String lastName,
	String email,
	String phoneNumber,
	LocalDate hireDate
) {
}
