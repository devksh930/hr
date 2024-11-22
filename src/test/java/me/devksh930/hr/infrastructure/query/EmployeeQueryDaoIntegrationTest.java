package me.devksh930.hr.infrastructure.query;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import me.devksh930.hr.domain.model.EmployeeQuery;
import me.devksh930.hr.test.config.DataBaseIntegrationTest;

class EmployeeQueryDaoIntegrationTest extends DataBaseIntegrationTest {

	@Autowired
	private EmployeeQueryDao employeeQueryDao;

	@Test
	@DisplayName("EmployeeQuery 페이지 요청 시 결과가 반환")
	void findEmployeePaged_shouldReturnPageResults() {
		PageRequest pageRequest = PageRequest.of(
			0,
			10
		);

		List<EmployeeQuery> employees = employeeQueryDao.findEmployeePaged(pageRequest);

		assertThat(employees).hasSize(10);
		assertThat(employees.get(0).jobId()).isNotBlank();
	}

	@Test
	@DisplayName("유효하지 않은 페이징 요청 시 빈 결과가 반환되어야 한다")
	void findEmployeePaged_shouldReturnEmptyForInvalidPage() {
		PageRequest pageRequest = PageRequest.of(100, 10); // 데이터가 없는 페이지

		List<EmployeeQuery> employees = employeeQueryDao.findEmployeePaged(pageRequest);

		assertThat(employees).isEmpty(); // 빈 결과 검증
	}

	@Test
	@DisplayName("전체 직원 수를 반환해야 한다.")
	void testCountEmployee() {
		long count = employeeQueryDao.countEmployee();

		assertThat(count).isGreaterThan(0);
	}
}