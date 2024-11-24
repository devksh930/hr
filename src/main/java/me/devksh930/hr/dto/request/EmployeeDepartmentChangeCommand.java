package me.devksh930.hr.dto.request;

public record EmployeeDepartmentChangeCommand(
	Integer employeeId,
	Integer departmentId
) {
}
