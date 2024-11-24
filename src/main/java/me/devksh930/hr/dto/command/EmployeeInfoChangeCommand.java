package me.devksh930.hr.dto.command;

import java.time.LocalDate;

public record EmployeeInfoChangeCommand(
	Integer employeeId,
	String firstName,
	String lastName,
	String email,
	String phoneNumber,
	LocalDate hireDate
) {
}
