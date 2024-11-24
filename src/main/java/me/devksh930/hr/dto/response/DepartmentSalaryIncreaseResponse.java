package me.devksh930.hr.dto.response;

import java.math.BigDecimal;

public record DepartmentSalaryIncreaseResponse(
	Integer employeeId,
	Integer departmentId,
	BigDecimal prevSalary,
	BigDecimal newSalary,
	Double percentage,
	boolean hasSalaryIncreased
) {
}
