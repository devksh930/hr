package me.devksh930.hr.application.mapper;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import me.devksh930.hr.domain.model.EmployeeJobHistoryQuery;
import me.devksh930.hr.dto.response.EmployeeJobHistoryResponse;

class EmployeeHistoryMapperTest {
	private final EmployeeHistoryMapper employeeHistoryMapper = new EmployeeHistoryMapper();

	@Test
	@DisplayName("EmployeeJobHistoryQuery를 Response로 변환한다.")
	void employeeHistoryQueryToResponse() {
		EmployeeJobHistoryQuery query = new EmployeeJobHistoryQuery(
			101,
			LocalDate.of(
				1989,
				9,
				21
			),
			LocalDate.of(
				1993,
				10,
				27
			),
			"AC_ACCOUNT",
			"Public Accountant",
			110,
			"Accounting"
		);

		EmployeeJobHistoryResponse response = employeeHistoryMapper.employeeHistoryQueryToResponse(query);

		assertThat(response).isNotNull();
		assertThat(response.employeeId()).isEqualTo(query.employeeId());
		assertThat(response.startDate()).isEqualTo(query.startDate());
		assertThat(response.endDate()).isEqualTo(query.endDate());
		assertThat(response.jobId()).isEqualTo(query.jobId());
		assertThat(response.jobTitle()).isEqualTo(query.jobTitle());
		assertThat(response.departmentId()).isEqualTo(query.departmentId());
		assertThat(response.departmentName()).isEqualTo(query.departmentName());
	}
}