package me.devksh930.hr.infrastructure.query;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import me.devksh930.hr.domain.model.EmployeeQuery;

@Component
@RequiredArgsConstructor
public class EmployeeQueryDao {
	private final JdbcClient jdbcClient;

	public List<EmployeeQuery> findEmployeePaged(final PageRequest pageRequest) {
		final String sql = """
			SELECT emp.employee_id   AS id,
			       emp.first_name    AS firstName,
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
}
