package me.devksh930.hr.infrastructure.command;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import me.devksh930.hr.domain.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query("""
		SELECT e FROM Employee e 
		       JOIN FETCH e.job 
		       JOIN FETCH e.manager 
		       JOIN FETCH e.department 
		       WHERE e.employeeId = :employeeId
		""")
	Optional<Employee> findByEmployeeIdFetchJobAndManageDepartment(@Param("employeeId") Integer employeeId);
}
