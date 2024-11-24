package me.devksh930.hr.application.mapper;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import me.devksh930.hr.domain.model.DepartmentQuery;
import me.devksh930.hr.dto.response.DepartmentResponse;

class DepartmentMapperTest {
	private final DepartmentMapper departmentQueryService = new DepartmentMapper();

	@Test
	@DisplayName("DepartmentQuery를 DepartmentResponse로 변환")
	void testDepartmentQueryToResponse() {
		final DepartmentQuery departmentQuery = new DepartmentQuery(
			1,
			"HR",
			100,
			101,
			"123 Main St",
			"12345",
			"New York",
			"NY",
			"US",
			"United States",
			1,
			"North America"
		);

		final DepartmentResponse response = departmentQueryService.departmentQueryToResponse(departmentQuery);

		assertThat(response.departmentId()).isEqualTo(departmentQuery.departmentId());
		assertThat(response.departmentName()).isEqualTo(departmentQuery.departmentName());
		assertThat(response.manageId()).isEqualTo(departmentQuery.manageId());
		assertThat(response.locationId()).isEqualTo(departmentQuery.locationId());
		assertThat(response.streetAddress()).isEqualTo(departmentQuery.streetAddress());
		assertThat(response.postalCode()).isEqualTo(departmentQuery.postalCode());
		assertThat(response.city()).isEqualTo(departmentQuery.city());
		assertThat(response.stateProvince()).isEqualTo(departmentQuery.stateProvince());
		assertThat(response.countryId()).isEqualTo(departmentQuery.countryId());
		assertThat(response.countryName()).isEqualTo(departmentQuery.countryName());
		assertThat(response.regionId()).isEqualTo(departmentQuery.regionId());
		assertThat(response.regionName()).isEqualTo(departmentQuery.regionName());
	}

}