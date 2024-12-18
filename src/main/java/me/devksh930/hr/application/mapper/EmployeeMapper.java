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

	public EmployeeDetailQueryResponse employeeDetailQueryToResponse(
		final
		EmployeeDetailQuery model
	) {
		return new EmployeeDetailQueryResponse(
			model.id(),
			model.firstName(),
			model.lastName(),
			model.jobId(),
			model.jobTitle(),
			model.departmentId(),
			model.departmentName(),
			model.locationId(),
			model.city(),
			model.stateProvince(),
			model.countryId(),
			model.countryName(),
			model.regionName(),
			model.salary(),
			model.commissionPct(),
			model.managerId()
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

