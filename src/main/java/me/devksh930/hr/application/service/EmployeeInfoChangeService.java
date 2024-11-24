package me.devksh930.hr.application.service;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.devksh930.hr.domain.entity.Employee;
import me.devksh930.hr.dto.command.EmployeeInfoChangeCommand;
import me.devksh930.hr.exception.EmployeeNotFoundException;
import me.devksh930.hr.infrastructure.command.EmployeeRepository;

@Service
@RequiredArgsConstructor
public class EmployeeInfoChangeService {
	private final EmployeeRepository employeeRepository;

	@Transactional
	public void employeeInfoChange(
		final EmployeeInfoChangeCommand command
	) {
		final Employee employee = employeeRepository.findById(command.employeeId())
			.orElseThrow(EmployeeNotFoundException::new);

		employee.changeInfo(
			command.firstName(),
			command.lastName(),
			command.email(),
			command.phoneNumber(),
			command.hireDate()
		);
	}
}
