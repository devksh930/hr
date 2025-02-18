package me.devksh930.hr.application.mapper;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import me.devksh930.hr.domain.entity.Department;
import me.devksh930.hr.domain.entity.Employee;
import me.devksh930.hr.domain.entity.Job;
import me.devksh930.hr.domain.model.EmployeeDetailQuery;
import me.devksh930.hr.domain.model.EmployeeQuery;
import me.devksh930.hr.dto.command.DepartmentSalaryIncreaseCommand;
import me.devksh930.hr.dto.response.DepartmentSalaryIncreaseResponse;
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
			LocalDate.of(
				1994,
				6,
				7
			),
			"110",
			"Accounting",
			"AC_ACCOUNT",
			"Public Accountant"
		);

		final EmployeeQueryResponse response = employeeMapper.employeeQueryToResponse(fixture);

		assertAll(
			() -> assertNotNull(response),
			() -> assertEquals(
				fixture.getId(),
				response.id()
			),
			() -> assertEquals(
				fixture.getFirstName(),
				response.firstName()
			),
			() -> assertEquals(
				fixture.getLastName(),
				response.lastName()
			),
			() -> assertEquals(
				fixture.getEmail(),
				response.email()
			),
			() -> assertEquals(
				fixture.getPhoneNumber(),
				response.phoneNumber()
			),
			() -> assertEquals(
				fixture.getHireDate(),
				response.hireDate()
			),
			() -> assertEquals(
				fixture.getDepartmentId(),
				response.departmentId()
			),
			() -> assertEquals(
				fixture.getDepartmentName(),
				response.departmentName()
			),
			() -> assertEquals(
				fixture.getJobId(),
				response.jobId()
			),
			() -> assertEquals(
				fixture.getJobTitle(),
				response.jobTitle()
			)
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
			new BigDecimal("0.15"),
			205
		);

		EmployeeDetailQueryResponse response = employeeMapper.employeeDetailQueryToResponse(fixture);

		assertAll(
			() -> assertNotNull(response),
			() -> assertEquals(
				fixture.getId(),
				response.id()
			),
			() -> assertEquals(
				fixture.getFirstName(),
				response.firstName()
			),
			() -> assertEquals(
				fixture.getLastName(),
				response.lastName()
			),
			() -> assertEquals(
				fixture.getJobId(),
				response.jobId()
			),
			() -> assertEquals(
				fixture.getJobTitle(),
				response.jobTitle()
			),
			() -> assertEquals(
				fixture.getDepartmentId(),
				response.departmentId()
			),
			() -> assertEquals(
				fixture.getDepartmentName(),
				response.departmentName()
			),
			() -> assertEquals(
				fixture.getLocationId(),
				response.locationId()
			),
			() -> assertEquals(
				fixture.getCity(),
				response.city()
			),
			() -> assertEquals(
				fixture.getStateProvince(),
				response.stateProvince()
			),
			() -> assertEquals(
				fixture.getCountryId(),
				response.countryId()
			),
			() -> assertEquals(
				fixture.getCountryName(),
				response.countryName()
			),
			() -> assertEquals(
				fixture.getRegionName(),
				response.regionName()
			),
			() -> assertEquals(
				fixture.getSalary(),
				response.salary()
			),
			() -> assertEquals(
				fixture.getCommissionPct(),
				response.commissionPct()
			),
			() -> assertEquals(
				fixture.getManagerId(),
				response.managerId()
			)
		);
	}

	@Test
	@DisplayName("Employee를 Response로 변환한다")
	void employeeToIncreaseSalaryResponse() {
		Job job = new Job(
			"DEV",
			"Developer",
			new BigDecimal("500.00"),
			new BigDecimal("1500.00")
		);
		Department department = new Department(
			1,
			null,
			null,
			null
		);

		final Employee fixture = new Employee(
			1,
			"John",
			"Doe",
			"john.doe@example.com",
			"123-456-7890",
			LocalDate.of(
				2020,
				1,
				1
			),
			job,
			new BigDecimal("1000.00"),
			0.1,
			null,
			department
		);

		final DepartmentSalaryIncreaseCommand command = new DepartmentSalaryIncreaseCommand(
			1,
			10.0
		);

		final DepartmentSalaryIncreaseResponse response = employeeMapper.employeeToIncreaseSalaryResponse(
			fixture,
			command
		);

		assertAll(
			() -> assertNotNull(response),
			() -> assertEquals(
				fixture.getEmployeeId(),
				response.employeeId()
			),
			() -> assertEquals(
				command.departmentId(),
				response.departmentId()
			),
			() -> assertEquals(
				fixture.getSalary(),
				response.prevSalary()
			),
			() -> assertEquals(
				fixture.increaseSalaryCalc(command.percentage()),
				response.newSalary()
			),
			() -> assertEquals(
				command.percentage(),
				response.percentage()
			),
			() -> assertEquals(
				fixture.isIncreaseSalary(command.percentage()),
				response.hasSalaryIncreased()
			)
		);
	}
}