package me.devksh930.hr.infrastructure.query;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import me.devksh930.hr.domain.model.DepartmentQuery;
import me.devksh930.hr.test.config.DataBaseIntegrationTest;

class DepartmentQueryDaoTest extends DataBaseIntegrationTest {
	@Autowired
	private DepartmentQueryDao departmentQueryDao;

	@Test
	@DisplayName("DepartmentQuery 페이지 요청 시 결과가 반환")
	void queryDepartmentWithPaging() {
		int pageSize = 10;
		long offset = 0;

		List<DepartmentQuery> departments = departmentQueryDao.queryDepartmentWithPaging(pageSize, offset);

		assertThat(departments).hasSize(10);
		assertThat(departments.get(0).getDepartmentName()).isNotBlank();
	}

	@Test
	@DisplayName("유효하지 않은 페이징 요청 시 빈 결과가 반환되어야 한다")
	void queryDepartmentWithPaging_shouldReturnEmptyForInvalidPage() {
		int pageSize = 10;
		long offset = 1000; // 데이터가 없는 페이지

		List<DepartmentQuery> departments = departmentQueryDao.queryDepartmentWithPaging(pageSize, offset);

		assertThat(departments).isEmpty(); // 빈 결과 검증
	}

	@Test
	@DisplayName("전체 부서 수를 반환해야 한다.")
	void departmentCount() {
		long count = departmentQueryDao.departmentCount();

		assertThat(count).isGreaterThan(0);
	}
}