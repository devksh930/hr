package me.devksh930.hr.application.mapper;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import me.devksh930.hr.domain.model.EmployeeDetailQuery;
import me.devksh930.hr.domain.model.EmployeeQuery;
import me.devksh930.hr.dto.response.EmployeeDetailQueryResponse;
import me.devksh930.hr.dto.response.EmployeeQueryResponse;

class EmployeeMapperTest {

	private EmployeeMapper employeeMapper = new EmployeeMapper();

	@Test
	@DisplayName("EmployeeQuery를 Response로 변환한다")
	void testEmployeeQueryToResponse() {
		final EmployeeQuery fixture = new EmployeeQuery(
			206,
			"William",
			"Gietz",
			"WGIETZ",
			"51hr5.123.8181",
			LocalDate.of(1994, 6, 7),
			"110",
			"Accounting",
			"AC_ACCOUNT",
			"Public Accountant"
		);


		final EmployeeQueryResponse response = employeeMapper.employeeQueryToResponse(fixture);

		assertAll(
			() -> assertNotNull(response),
			() -> assertEquals(fixture.id(), response.id()),
			() -> assertEquals(fixture.firstName(), response.firstName()),
			() -> assertEquals(fixture.lastName(), response.lastName()),
			() -> assertEquals(fixture.email(), response.email()),
			() -> assertEquals(fixture.phoneNumber(), response.phoneNumber()),
			() -> assertEquals(fixture.hireDate(), response.hireDate()),
			() -> assertEquals(fixture.departmentId(), response.departmentId()),
			() -> assertEquals(fixture.departmentName(), response.departmentName()),
			() -> assertEquals(fixture.jobId(), response.jobId()),
			() -> assertEquals(fixture.jobTitle(), response.jobTitle())
		);
	}

	@Test
	@DisplayName("EmployeeDetailQuery를 Response로 변환한다")
	void employeeDetailQueryToResponse_shouldMapFieldsCorrectly() {
		// Given
		EmployeeDetailQuery fixture = new EmployeeDetailQuery(
			206,
			"William",
			"Gietz",
			"AC_ACCOUNT",
			"Public Accountant",
			110,
			"Accounting",
			1700,
			"Seattle",
			"Washington",
			"US",
			"United States of America",
			"Americas",
			new BigDecimal("8300.00"),
			null,
			205
		);

		EmployeeDetailQueryResponse response = employeeMapper.employeeDetailQueryToResponse(fixture);

		assertAll(
			() -> assertNotNull(response),
			() -> assertEquals(fixture.id(), response.id()),
			() -> assertEquals(fixture.firstName(), response.firstName()),
			() -> assertEquals(fixture.lastName(), response.lastName()),
			() -> assertEquals(fixture.jobId(), response.jobId()),
			() -> assertEquals(fixture.jobTitle(), response.jobTitle()),
			() -> assertEquals(fixture.departmentId(), response.departmentId()),
			() -> assertEquals(fixture.departmentName(), response.departmentName()),
			() -> assertEquals(fixture.locationId(), response.locationId()),
			() -> assertEquals(fixture.city(), response.city()),
			() -> assertEquals(fixture.stateProvince(), response.stateProvince()),
			() -> assertEquals(fixture.countryId(), response.countryId()),
			() -> assertEquals(fixture.countryName(), response.countryName()),
			() -> assertEquals(fixture.regionName(), response.regionName()),
			() -> assertEquals(fixture.salary(), response.salary()),
			() -> assertEquals(fixture.commissionPct(),response.commissionPct()),
			() -> assertEquals(fixture.managerId(), response.managerId())
		);
	}
}