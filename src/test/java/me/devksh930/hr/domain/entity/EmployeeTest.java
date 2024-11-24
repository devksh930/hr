package me.devksh930.hr.domain.entity;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EmployeeTest {

	@Test
	@DisplayName("직원의 정보를 변경한다")
	void testChangeInfo() {
		final Job job = new Job(
			"MK_MAN",
			"Manager",
			new BigDecimal("12000.00"),
			new BigDecimal("15000.00")
		);
		final Department department = new Department(
			20,
			"Marketing",
			null,
			null
		);
		final Employee fixture = new Employee(
			201,
			"Michael",
			"Hartstein",
			"MHARTSTE",
			"515.123.5555",
			LocalDate.of(
				1996,
				2,
				17
			),
			job,
			new BigDecimal("13000.00"),
			null,
			null,
			department
		);

		assertThat(fixture.getFirstName()).isEqualTo("Michael");
		assertThat(fixture.getLastName()).isEqualTo("Hartstein");
		assertThat(fixture.getEmail()).isEqualTo("MHARTSTE");
		assertThat(fixture.getPhoneNumber()).isEqualTo("515.123.5555");
		assertThat(fixture.getHireDate()).isEqualTo(LocalDate.of(
			1996,
			2,
			17
		));
	}

	@Test
	@DisplayName("직무가 변경이 된다")
	void testChangeJob() {
		Job oldJob = new Job(
			"MK_MAN",
			"Manager",
			new BigDecimal("12000.00"),
			new BigDecimal("15000.00")
		);
		Job newJob = new Job(
			"MK_REP",
			"Marketing Representative",
			new BigDecimal("6000.00"),
			new BigDecimal("9000.00")
		);
		Department department = new Department(
			20,
			"Marketing",
			null,
			null
		);
		Employee fixture = new Employee(
			201,
			"Michael",
			"Hartstein",
			"MHARTSTE",
			"515.123.5555",
			LocalDate.of(
				1996,
				2,
				17
			),
			oldJob,
			new BigDecimal("13000.00"),
			null,
			null,
			department
		);

		fixture.changeJob(newJob);

		assertThat(fixture.getJob()).isEqualTo(newJob);
	}

	@Test
	@DisplayName("동일한 Job으로 변경시 변깅이 되지 않는다")
	void testChangeJob_notChanged() {
		Job job = new Job(
			"MK_MAN",
			"Manager",
			new BigDecimal("12000.00"),
			new BigDecimal("15000.00")
		);
		Department department = new Department(
			20,
			"Marketing",
			null,
			null
		);
		Employee fixture = new Employee(
			201,
			"Michael",
			"Hartstein",
			"MHARTSTE",
			"515.123.5555",
			LocalDate.of(
				1996,
				2,
				17
			),
			job,
			new BigDecimal("13000.00"),
			null,
			null,
			department
		);

		fixture.changeJob(job);

		assertThat(fixture.getJob()).isEqualTo(job);
	}

	@Test
	@DisplayName("기존 직무와 동일한지 검증한다")
	void testIsSameJob() {
		Job currentJob = new Job(
			"MK_MAN",
			"Manager",
			new BigDecimal("12000.00"),
			new BigDecimal("15000.00")
		);
		Department department = new Department(
			20,
			"Marketing",
			null,
			null
		);
		Employee employee = new Employee(
			201,
			"Michael",
			"Hartstein",
			"MHARTSTE",
			"515.123.5555",
			LocalDate.of(1996,
				2,
				17
			),
			currentJob,
			new BigDecimal("13000.00"),
			null,
			null,
			department
		);

		// 동일한 직무인지 확인
		boolean result = employee.isSameJob(currentJob);

		// 검증
		assertThat(result).isTrue();
	}

	@Test
	@DisplayName("기존 직무와 다른지 검증한다")
	void testIsSameJob_notSameJob() {
		Job currentJob = new Job(
			"MK_MAN",
			"Manager",
			new BigDecimal("12000.00"),
			new BigDecimal("15000.00")
		);
		Job differentJob = new Job(
			"MK_REP",
			"Marketing Representative",
			new BigDecimal("6000.00"),
			new BigDecimal("9000.00")
		);
		Department department = new Department(
			20,
			"Marketing",
			null,
			null
		);
		Employee employee = new Employee(
			201,
			"Michael",
			"Hartstein",
			"MHARTSTE",
			"515.123.5555",
			LocalDate.of(1996,
				2,
				17
			),
			currentJob,
			new BigDecimal("13000.00"),
			null,
			null,
			department
		);

		boolean result = employee.isSameJob(differentJob);

		assertThat(result).isFalse();
	}
}