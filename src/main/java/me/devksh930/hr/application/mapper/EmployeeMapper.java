package me.devksh930.hr.application.mapper;

import org.springframework.stereotype.Component;

import me.devksh930.hr.domain.model.EmployeeQuery;
import me.devksh930.hr.dto.response.EmployeeQueryResponse;

@Component
public class EmployeeMapper {
	public EmployeeQueryResponse employeeQueryToResponse(
		final EmployeeQuery model
	) {
		return new EmployeeQueryResponse(
			model.id(),
			model.firstName(),
			model.lastName(),
			model.email(),
			model.phoneNumber(),
			model.hireDate(),
			model.departmentId(),
			model.departmentName(),
			model.jobId(),
			model.jobTitle()
		);
	}
}
