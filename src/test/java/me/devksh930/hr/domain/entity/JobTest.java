package me.devksh930.hr.domain.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JobTest {

	@Test
	@DisplayName("isSalaryAboveMin: 급여가 최소 급여 이상인 경우 true 반환")
	void testIsSalaryAboveMin_SalaryAboveMin_ReturnsTrue() {
		final Job fixture = new Job(
			null,
			null,
			new BigDecimal("1000"),
			new BigDecimal("2000")
		);

		assertTrue(fixture.isSalaryAboveMin(new BigDecimal("1500")));
	}

	@Test
	@DisplayName("isSalaryAboveMin: 급여가 최소 급여와 같은 경우 true 반환")
	void testIsSalaryAboveMin_SalaryEqualsMin_ReturnsTrue() {
		final Job fixture = new Job(
			null,
			null,
			new BigDecimal("1000"),
			new BigDecimal("2000")
		);
		assertTrue(fixture.isSalaryAboveMin(new BigDecimal("1000")));
	}

	@Test
	@DisplayName("isSalaryAboveMin: 급여가 최소 급여 미만인 경우 false 반환")
	void testIsSalaryAboveMin_SalaryBelowMin_ReturnsFalse() {
		final Job fixture = new Job(
			null,
			null,
			new BigDecimal("1000"),
			new BigDecimal("2000")
		);
		assertFalse(fixture.isSalaryAboveMin(new BigDecimal("500")));
	}

	@Test
	@DisplayName("isSalaryBelowMax: 급여가 최대 급여 이하인 경우 true 반환")
	void testIsSalaryBelowMax_SalaryBelowMax_ReturnsTrue() {
		final Job fixture = new Job(
			null,
			null,
			new BigDecimal("1000"),
			new BigDecimal("2000")
		);
		assertTrue(fixture.isSalaryBelowMax(new BigDecimal("1500")));
	}

	@Test
	@DisplayName("isSalaryBelowMax: 급여가 최대 급여와 같은 경우 true 반환")
	void testIsSalaryBelowMax_SalaryEqualsMax_ReturnsTrue() {
		final Job fixture = new Job(
			null,
			null,
			new BigDecimal("1000"),
			new BigDecimal("2000")
		);
		assertTrue(fixture.isSalaryBelowMax(new BigDecimal("2000")));
	}

	@Test
	@DisplayName("isSalaryBelowMax: 급여가 최대 급여 초과인 경우 false 반환")
	void testIsSalaryBelowMax_SalaryAboveMax_ReturnsFalse() {
		final Job fixture = new Job(
			null,
			null,
			new BigDecimal("1000"),
			new BigDecimal("2000")
		);
		assertFalse(fixture.isSalaryBelowMax(new BigDecimal("2500")));
	}

	@Test
	@DisplayName("isWithinRange: 급여가 범위 내에 있는 경우 true 반환")
	void testIsWithinRange_SalaryWithinRange_ReturnsTrue() {
		final Job fixture = new Job(
			null,
			null,
			new BigDecimal("1000"),
			new BigDecimal("2000")
		);
		assertTrue(fixture.isWithinRange(new BigDecimal("1500")));
	}

	@Test
	@DisplayName("isWithinRange: 급여가 최소 급여와 같은 경우 true 반환")
	void testIsWithinRange_SalaryEqualsMin_ReturnsTrue() {
		final Job fixture = new Job(
			null,
			null,
			new BigDecimal("1000"),
			new BigDecimal("2000")
		);
		assertTrue(fixture.isWithinRange(new BigDecimal("1000")));
	}

	@Test
	@DisplayName("isWithinRange: 급여가 최대 급여와 같은 경우 true 반환")
	void testIsWithinRange_SalaryEqualsMax_ReturnsTrue() {
		final Job fixture = new Job(
			null,
			null,
			new BigDecimal("1000"),
			new BigDecimal("2000")
		);
		assertTrue(fixture.isWithinRange(new BigDecimal("2000")));
	}

	@Test
	@DisplayName("isWithinRange: 급여가 최소 급여 미만인 경우 false 반환")
	void testIsWithinRange_SalaryBelowMin_ReturnsFalse() {
		final Job fixture = new Job(
			null,
			null,
			new BigDecimal("1000"),
			new BigDecimal("2000")
		);
		assertFalse(fixture.isWithinRange(new BigDecimal("500")));
	}

	@Test
	@DisplayName("isWithinRange: 급여가 최대 급여 초과인 경우 false 반환")
	void testIsWithinRange_SalaryAboveMax_ReturnsFalse() {
		final Job fixture = new Job(
			null,
			null,
			new BigDecimal("1000"),
			new BigDecimal("2000")
		);
		assertFalse(fixture.isWithinRange(new BigDecimal("2500")));
	}
}

