package me.devksh930.hr.infrastructure.query;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import me.devksh930.hr.domain.model.EmployeeJobHistoryQuery;
import me.devksh930.hr.test.config.DataBaseIntegrationTest;

class EmployeeHistoryQueryDaoIntegrationTest extends DataBaseIntegrationTest {
	@Autowired
	private EmployeeHistoryQueryDao employeeHistoryQueryDao;

	@Test
	@DisplayName("해당 하는 직원의 history 수가 반환된다.")
	void countJobHistoryByEmployeeId() {

		final Integer employeeId = 101;

		final long count = employeeHistoryQueryDao.countJobHistoryByEmployeeId(employeeId);

		assertThat(count).isGreaterThan(0);
	}

	@Test
	@DisplayName("해당 하는 직원의 history 요청시 페이징 결과가 반환")
	void findJobHistoryByEmployeeId() {
		final PageRequest pageRequest = PageRequest.of(
			0,
			10
		);

		final List<EmployeeJobHistoryQuery> jobHistoryQueries = employeeHistoryQueryDao.findJobHistoryByEmployeeId(
			101,
			pageRequest
		);

		assertThat(jobHistoryQueries).isNotEmpty();
		assertThat(jobHistoryQueries.get(0).getEmployeeId()).isEqualTo(101);
		assertThat(jobHistoryQueries.get(0).getStartDate()).isNotNull();
		assertThat(jobHistoryQueries.get(0).getJobId()).isNotBlank();
		assertThat(jobHistoryQueries.get(0).getJobTitle()).isNotBlank();
	}

	@Test
	@DisplayName("유효하지 않은 페이징 요청 시 빈 결과가 반환되어야 한다")
	void findJobHistoryByEmployeeId_shouldReturnEmptyForInvalidPage() {
		PageRequest pageRequest = PageRequest.of(
			100,
			10
		); // 데이터가 없는 페이지

		final List<EmployeeJobHistoryQuery> jobHistoryQueries = employeeHistoryQueryDao.findJobHistoryByEmployeeId(
			101,
			pageRequest
		);
		assertThat(jobHistoryQueries).isEmpty(); // 빈 결과 검증
	}

	@Test
	@DisplayName("존재하지 않는 직원의 정보를 조회 할경우")
	void ffindJobHistoryByEmployeeId_notFound() {
		final PageRequest pageRequest = PageRequest.of(
			0,
			10
		);

		final Integer employeeId = 0;

		final List<EmployeeJobHistoryQuery> jobHistoryQueries = employeeHistoryQueryDao.findJobHistoryByEmployeeId(
			employeeId,
			pageRequest
		);
		assertThat(jobHistoryQueries).isEmpty();
	}
}