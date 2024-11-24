package me.devksh930.hr.application.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import me.devksh930.hr.domain.entity.Employee;
import me.devksh930.hr.dto.request.EmployeeDepartmentChangeCommand;
import me.devksh930.hr.exception.DepartmentNotFoundException;
import me.devksh930.hr.exception.EmployeeNotFoundException;
import me.devksh930.hr.infrastructure.command.DepartmentRepository;
import me.devksh930.hr.infrastructure.command.EmployeeRepository;

@ExtendWith(MockitoExtension.class)
class EmployeeDepartmentChangeServiceTest {

	@Mock
	private EmployeeRepository employeeRepository;

	@Mock
	private DepartmentRepository departmentRepository;

	@InjectMocks
	private EmployeeDepartmentChangeService employeeDepartmentChangeService;

	@Test
	@DisplayName("changeDepartment: employee가 존재하지 않을 때 EmployeeNotFoundException 발생")
	void testChangeDepartment_EmployeeNotFound() {
		EmployeeDepartmentChangeCommand command = new EmployeeDepartmentChangeCommand(
			1,
			1
		);
		when(employeeRepository.findByEmployeeIdFetchJobAndManageDepartment(command.employeeId()))
			.thenReturn(Optional.empty());

		assertThrows(
			EmployeeNotFoundException.class,
			() -> {
				employeeDepartmentChangeService.changeDepartment(command);
			}
		);
	}

	@Test
	@DisplayName("changeDepartment: department가 존재하지 않을 때 DepartmentNotFoundException 발생")
	void testChangeDepartment_DepartmentNotFound() {
		EmployeeDepartmentChangeCommand command = new EmployeeDepartmentChangeCommand(
			1,
			1
		);
		Employee employee = mock(Employee.class);
		when(employeeRepository.findByEmployeeIdFetchJobAndManageDepartment(command.employeeId()))
			.thenReturn(Optional.of(employee));
		when(departmentRepository.findByIddepartmentIdFetchManager(command.departmentId()))
			.thenReturn(Optional.empty());

		assertThrows(
			DepartmentNotFoundException.class,
			() -> {
				employeeDepartmentChangeService.changeDepartment(command);
			}
		);
	}
}