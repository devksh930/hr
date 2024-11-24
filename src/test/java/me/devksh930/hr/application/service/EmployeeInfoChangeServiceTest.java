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

import me.devksh930.hr.dto.command.EmployeeInfoChangeCommand;
import me.devksh930.hr.exception.EmployeeNotFoundException;
import me.devksh930.hr.infrastructure.command.EmployeeRepository;

@ExtendWith(MockitoExtension.class)
class EmployeeInfoChangeServiceTest {

	@Mock
	private EmployeeRepository employeeRepository;

	@InjectMocks
	private EmployeeInfoChangeService employeeInfoChangeService;

	@Test
	@DisplayName("employeeInfoChange: employee가 존재하지 않을 때 EmployeeNotFoundException 발생")
	void testEmployeeInfoChange_EmployeeNotFound() {
		final EmployeeInfoChangeCommand command = mock(EmployeeInfoChangeCommand.class);

		when(employeeRepository.findById(command.employeeId()))
			.thenReturn(Optional.empty());

		assertThrows(
			EmployeeNotFoundException.class,
			() -> {
				employeeInfoChangeService.employeeInfoChange(command);
			}
		);
	}
}