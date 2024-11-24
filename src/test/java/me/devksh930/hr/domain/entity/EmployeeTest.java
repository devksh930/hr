package me.devksh930.hr.domain.entity;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

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
			"KIM",
			"SUNGHO",
			"TEST",
			"123.123.4444",
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

		fixture.changeInfo(
			"Michael",
			"Hartstein",
			"MHARTSTE",
			"515.123.5555",
			LocalDate.of(
				1996,
				2,
				17
			)
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

	@Test
	@DisplayName("퍼센트로 급여를 증가 시킨다")
	public void testIncreaseSalaryCalc() {
		Job job = new Job(
			"DEV",
			"Developer",
			new BigDecimal("500.00"),
			new BigDecimal("1500.00")
		);
		Department department = new Department(
			null,
			null,
			null,
			null
		);
		Employee fixture = new Employee(
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

		final Double percentage = 0.1; // 10% 증가
		final BigDecimal expectedNewSalary = new BigDecimal("1100.00"); // 1000 + 10% of 1000

		final BigDecimal newSalary = fixture.increaseSalaryCalc(percentage);

		assertEquals(
			0,
			expectedNewSalary.compareTo(newSalary)
		);
	}

	@Test
	@DisplayName("급여 증가가 범위 내에 있는지 테스트")
	public void testIsIncreaseSalary() {
		Job job = new Job(
			"DEV",
			"Developer",
			new BigDecimal("500.00"),
			new BigDecimal("1500.00")
		);
		Department department = new Department(
			null,
			null,
			null,
			null
		);
		Employee fixture = new Employee(
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

		Double percentage = 0.10; // 10% 증가
		assertTrue(fixture.isIncreaseSalary(percentage));

		percentage = 1.0; // 100% 증가
		assertFalse(fixture.isIncreaseSalary(percentage));
	}
}