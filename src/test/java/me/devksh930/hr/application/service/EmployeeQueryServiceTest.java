package me.devksh930.hr.application.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import me.devksh930.hr.application.mapper.EmployeeMapper;
import me.devksh930.hr.exception.EmployeeNotFoundException;
import me.devksh930.hr.infrastructure.query.EmployeeQueryDao;

@ExtendWith(MockitoExtension.class)
class EmployeeQueryServiceTest {
	@Mock
	private EmployeeQueryDao employeeQueryDao;

	@Mock
	private EmployeeMapper employeeMapper;

	@InjectMocks
	private EmployeeQueryService employeeQueryService;

	@Test
	@DisplayName("존재하지않는 직원 조회시 REmployeeNotFoundException을이 발생한다")
	void queryEmployeeDetail_notFound() {
		Integer employeeId = 0;

		when(employeeQueryDao.findEmployeeById(anyInt())).thenReturn(Optional.empty());

		assertThrows(
			EmployeeNotFoundException.class,
			() -> employeeQueryService.queryEmployeeDetail(employeeId)
		);

	}
}