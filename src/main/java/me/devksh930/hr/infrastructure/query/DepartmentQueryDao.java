package me.devksh930.hr.infrastructure.query;

import java.util.List;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import me.devksh930.hr.domain.model.DepartmentQuery;

@Component
@RequiredArgsConstructor
public class DepartmentQueryDao {
	private final JdbcClient jdbcClient;

	public List<DepartmentQuery> queryDepartmentWithPaging(
		final int pageSize,
		final long offset
	) {
		final String sql = """
			SELECt d.department_id   AS departmentId,
			       d.department_name AS departmentName,
			       d.manager_id      AS manageId,
			       d.location_id     AS locationId,
			       l.street_address  AS streetAddress,
			       l.postal_code     AS postalCode,
			       l.city            AS city,
			       l.state_province  AS stateProvince,
			       l.country_id      AS countryId,
			       c.country_name    AS countryName,
			       c.region_id       AS regionId,
			       r.region_name     AS regionName
			FROM departments d
			         JOIN locations l ON d.location_id = l.location_id
			         JOIN countries c ON l.country_id = c.country_id
			         JOIN regions r ON c.region_id = r.region_id
			LIMIT ? OFFSET ?;
			""";
		return jdbcClient.sql(sql)
			.param(pageSize)
			.param(offset)
			.query(DepartmentQuery.class)
			.list();
	}

	public long departmentCount() {
		final String sql = """
			SELECT COUNT(*) FROM departments
			""";
		return jdbcClient.sql(sql)
			.query(Long.class)
			.single();
	}
}
