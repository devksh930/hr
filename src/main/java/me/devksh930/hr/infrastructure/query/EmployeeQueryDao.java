package me.devksh930.hr.infrastructure.query;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import me.devksh930.hr.domain.model.EmployeeDetailQuery;
import me.devksh930.hr.domain.model.EmployeeQuery;

@Component
@RequiredArgsConstructor
public class EmployeeQueryDao {
	private final JdbcClient jdbcClient;

	public List<EmployeeQuery> findEmployeePaged(final PageRequest pageRequest) {
		final String sql = """
			SELECT emp.employee_id   AS id,
			       emp.first_name     AS firstName,
			       emp.last_name     AS lastName,
			       emp.email         AS email,
			       emp.phone_number  AS phoneNumber,
			       emp.hire_date     AS hireDate,
			       d.department_id   AS departmentId,
			       d.department_name AS departmentName,
			       emp.job_id        AS jobId,
			       j.job_title       AS jobTitle
			FROM employees emp
			         INNER JOIN departments d ON emp.department_id = d.department_id
			         INNER JOIN jobs j on emp.job_id = j.job_id
			LIMIT ? OFFSET ?
			""";
		return jdbcClient.sql(sql)
			.param(
				pageRequest.getPageSize()
			)
			.param(
				pageRequest.getOffset()
			)
			.query(EmployeeQuery.class)
			.list();
	}

	public long countEmployee() {
		final String sql = """
			SELECT COUNT(employee_id) FROM employees
			""";

		return jdbcClient.sql(sql)
			.query(Long.class)
			.single();
	}

	public Optional<EmployeeDetailQuery> findEmployeeById(final Integer employeeId) {

		final String sql = """
			SELECT e.employee_id     AS id,
			       e.first_name       AS firstName,
			       e.last_name       AS lastName,
			       e.job_id          AS jobId,
			       j.job_title       AS jobTitle,
			       e.department_id   AS departmentId,
			       d.department_name AS departmentName,
			       d.location_id     AS locationId,
			       l.city            AS city,
			       l.state_province  AS stateProvince,
			       l.country_id      AS countryId,
			       c.country_name    AS countryName,
			       r.region_name     AS regionName,
			       e.salary			 AS salary,
			       e.commission_pct  AS commissionPct,
			       e.manager_id      AS managerId
			FROM employees e
			         INNER JOIN departments d ON e.department_id = d.department_id
			         INNER JOIN jobs j ON e.job_id = j.job_id
			         INNER JOIN locations l ON d.location_id = l.location_id
			         INNER JOIN countries c ON l.country_id = c.country_id
			         INNER JOIN regions r ON c.region_id = r.region_id
			WHERE e.employee_id = ?
			""";
		return jdbcClient.sql(sql)
			.param(employeeId)
			.query(EmployeeDetailQuery.class)
			.optional();

	}
}
