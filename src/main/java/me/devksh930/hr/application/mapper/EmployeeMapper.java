package me.devksh930.hr.application.mapper;

import org.springframework.stereotype.Component;

import me.devksh930.hr.domain.entity.Employee;
import me.devksh930.hr.domain.model.EmployeeDetailQuery;
import me.devksh930.hr.domain.model.EmployeeQuery;
import me.devksh930.hr.dto.command.DepartmentSalaryIncreaseCommand;
import me.devksh930.hr.dto.response.DepartmentSalaryIncreaseResponse;
import me.devksh930.hr.dto.response.EmployeeDetailQueryResponse;
import me.devksh930.hr.dto.response.EmployeeQueryResponse;

@Component
public class EmployeeMapper {
	public EmployeeQueryResponse employeeQueryToResponse(
		final EmployeeQuery model
	) {
		return new EmployeeQueryResponse(
			model.getId(),
			model.getFirstName(),
			model.getLastName(),
			model.getEmail(),
			model.getPhoneNumber(),
			model.getHireDate(),
			model.getDepartmentId(),
			model.getDepartmentName(),
			model.getJobId(),
			model.getJobTitle()
		);
	}

	public EmployeeDetailQueryResponse employeeDetailQueryToResponse(
		final
		EmployeeDetailQuery model
	) {
		return new EmployeeDetailQueryResponse(
			model.getId(),
			model.getFirstName(),
			model.getLastName(),
			model.getJobId(),
			model.getJobTitle(),
			model.getDepartmentId(),
			model.getDepartmentName(),
			model.getLocationId(),
			model.getCity(),
			model.getStateProvince(),
			model.getCountryId(),
			model.getCountryName(),
			model.getRegionName(),
			model.getSalary(),
			model.getCommissionPct(),
			model.getManagerId()
		);
	}

	public DepartmentSalaryIncreaseResponse employeeToIncreaseSalaryResponse(
		final Employee employee,
		final DepartmentSalaryIncreaseCommand command
	) {

		return new DepartmentSalaryIncreaseResponse(
			employee.getEmployeeId(),
			command.departmentId(),
			employee.getSalary(),
			employee.increaseSalaryCalc(command.percentage()),
			command.percentage(),
			employee.isIncreaseSalary(command.percentage())
		);
	}
}

