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

		assertThat(response.departmentId()).isEqualTo(departmentQuery.getDepartmentId());
		assertThat(response.departmentName()).isEqualTo(departmentQuery.getDepartmentName());
		assertThat(response.manageId()).isEqualTo(departmentQuery.getManageId());
		assertThat(response.locationId()).isEqualTo(departmentQuery.getLocationId());
		assertThat(response.streetAddress()).isEqualTo(departmentQuery.getStreetAddress());
		assertThat(response.postalCode()).isEqualTo(departmentQuery.getPostalCode());
		assertThat(response.city()).isEqualTo(departmentQuery.getCity());
		assertThat(response.stateProvince()).isEqualTo(departmentQuery.getStateProvince());
		assertThat(response.countryId()).isEqualTo(departmentQuery.getCountryId());
		assertThat(response.countryName()).isEqualTo(departmentQuery.getCountryName());
		assertThat(response.regionId()).isEqualTo(departmentQuery.getRegionId());
		assertThat(response.regionName()).isEqualTo(departmentQuery.getRegionName());
	}

}