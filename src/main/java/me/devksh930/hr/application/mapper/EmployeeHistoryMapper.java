package me.devksh930.hr.application.mapper;

import org.springframework.stereotype.Component;

import me.devksh930.hr.domain.model.EmployeeJobHistoryQuery;
import me.devksh930.hr.dto.response.EmployeeJobHistoryResponse;

@Component
public class EmployeeHistoryMapper {

	public EmployeeJobHistoryResponse employeeHistoryQueryToResponse(
		EmployeeJobHistoryQuery model
	) {

		return new EmployeeJobHistoryResponse(
			model.getEmployeeId(),
			model.getStartDate(),
			model.getEndDate(),
			model.getJobId(),
			model.getJobTitle(),
			model.getDepartmentId(),
			model.getDepartmentName()
		);
	}

}
