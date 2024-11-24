package me.devksh930.hr.infrastructure.command;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.transaction.Transactional;
import me.devksh930.hr.domain.entity.Employee;
import me.devksh930.hr.test.config.DataBaseIntegrationTest;

@Transactional
class EmployeeRepositoryTest extends DataBaseIntegrationTest {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	@DisplayName("직원의 급여를 퍼센테이지로 업데이트 한다.")
	void updateSalaryByEmployeeIds() {

		final Integer updateEmployeeId = 101;
		final Double percnetage = 0.1;
		final Double updatePercentage = 1 + percnetage;

		final Employee beforerEmploye = employeeRepository.findById(updateEmployeeId).get();
		final BigDecimal beforeCalcSalary = beforerEmploye.increaseSalaryCalc(percnetage);

		final List<Integer> employeeIds = List.of(101);
		final int updateCount = employeeRepository.updateSalaryByEmployeeIds(
			employeeIds,
			BigDecimal.valueOf(updatePercentage)
		);

		final Employee afterEmployee = employeeRepository.findById(updateEmployeeId).get();
		final BigDecimal afterCalcSalary = afterEmployee.increaseSalaryCalc(percnetage);

		assertThat(updateCount).isEqualTo(1);
		assertEquals(
			0,
			beforeCalcSalary.compareTo(afterCalcSalary)
		);
	}
}