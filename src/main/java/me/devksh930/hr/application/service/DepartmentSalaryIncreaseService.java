package me.devksh930.hr.application.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.devksh930.hr.application.mapper.EmployeeMapper;
import me.devksh930.hr.domain.entity.Employee;
import me.devksh930.hr.dto.command.DepartmentSalaryIncreaseCommand;
import me.devksh930.hr.dto.response.DepartmentSalaryIncreaseResponse;
import me.devksh930.hr.infrastructure.command.EmployeeRepository;

@Service
@RequiredArgsConstructor
public class DepartmentSalaryIncreaseService {
	private final EmployeeRepository employeeRepository;
	private final EmployeeMapper employeeMapper;

	@Transactional
	public List<DepartmentSalaryIncreaseResponse> departmentIncreaseSalary(
		final DepartmentSalaryIncreaseCommand command
	) {
		final List<Employee> employees = employeeRepository.findByDepartmentId(command.departmentId());

		final List<Integer> updatableEmployeeIds = employees.stream()
			.filter(e -> e.isIncreaseSalary(command.percentage()))
			.map(Employee::getEmployeeId)
			.toList();

		employeeRepository.updateSalaryByEmployeeIds(
			updatableEmployeeIds,
			BigDecimal.ONE.add(BigDecimal.valueOf(command.percentage()))
		);

		return employees.stream()
			.map(employee -> employeeMapper.employeeToIncreaseSalaryResponse(
				employee,
				command
			))
			.toList();
	}
}
