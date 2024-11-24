package me.devksh930.hr.infrastructure.command;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import me.devksh930.hr.domain.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@EntityGraph(attributePaths = {"job","manager", "department"})
	Optional<Employee> findByEmployeeId(@Param("employeeId") Integer employeeId);
}
