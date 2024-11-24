package me.devksh930.hr.infrastructure.command;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import me.devksh930.hr.domain.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	@Query("""
		SELECT d 
		FROM Department d
		JOIN FETCH d.manager
		WHERE d.departmentId = :departmentId
		""")
	Optional<Department> findByIddepartmentIdFetchManager(final Integer departmentId);
}