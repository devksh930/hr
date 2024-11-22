package me.devksh930.hr.domain.model;

import java.math.BigDecimal;

public record EmployeeDetailQuery(
	Integer id,
	String firstName,
	String lastName,
	String jobId,
	String jobTitle,
	Integer departmentId,
	String departmentName,
	Integer locationId,
	String city,
	String stateProvince,
	String countryId,
	String countryName,
	String regionName,
	BigDecimal salary,
	BigDecimal commissionPct,
	Integer managerId
) {
}
