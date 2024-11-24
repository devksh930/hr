package me.devksh930.hr.application.service;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.devksh930.hr.domain.entity.Department;
import me.devksh930.hr.domain.entity.Employee;
import me.devksh930.hr.dto.request.EmployeeDepartmentChangeCommand;
import me.devksh930.hr.exception.DepartmentNotFoundException;
import me.devksh930.hr.exception.EmployeeNotFoundException;
import me.devksh930.hr.infrastructure.command.DepartmentRepository;
import me.devksh930.hr.infrastructure.command.EmployeeRepository;

@Service
@RequiredArgsConstructor
public class EmployeeDepartmentChangeService {
	private final EmployeeRepository employeeRepository;
	private final DepartmentRepository departmentRepository;

	@Transactional
	public void changeDepartment(
		final
		EmployeeDepartmentChangeCommand command
	) {
		final Employee employee = employeeRepository.findByEmployeeIdFetchJobAndManageDepartment(command.employeeId())
			.orElseThrow(EmployeeNotFoundException::new);

		final Department department = departmentRepository.findByIddepartmentIdFetchManager(command.departmentId())
			.orElseThrow(DepartmentNotFoundException::new);

		employee.changeDepartment(department);
	}
}
