package me.devksh930.hr.dto.command;

public record DepartmentSalaryIncreaseCommand(
	Integer departmentId,
	Double percentage
) {
}
