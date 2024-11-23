package me.devksh930.hr.infrastructure.query;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import me.devksh930.hr.domain.model.EmployeeJobHistoryQuery;

@Component
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EmployeeHistoryQueryDao {
	private final JdbcClient jdbcClient;

	public long countJobHistoryByEmployeeId(
		final Integer employeeId
	) {
		final String sql = """
			SELECT COUNT(*)
			FROM job_history jh
			WHERE employee_id = ?
			""";
		return jdbcClient.sql(sql)
			.param(employeeId)
			.query(Long.class)
			.single();
	}

	public List<EmployeeJobHistoryQuery> findJobHistoryByEmployeeId(
		final Integer employeeId,
		final PageRequest pageRequest
	) {
		final String sql = """
			SELECT jh.employee_id AS employeeId,
			       jh.start_date AS startDate,
			       jh.end_date AS endDate,
			       j.job_id AS jobId,
			       j.job_title AS jobTitle,
			       d.department_id AS departmentId,
			       d.department_name AS departmentName
			FROM job_history jh
			         JOIN jobs j ON jh.job_id = j.job_id
			         JOIN departments d ON jh.department_id = d.department_id
			WHERE jh.employee_id = ?
			LIMIT ? OFFSET ?
			""";
		return jdbcClient.sql(sql)
			.param(employeeId)
			.param(pageRequest.getPageSize())
			.param(pageRequest.getOffset())
			.query(EmployeeJobHistoryQuery.class)
			.list();
	}
}
