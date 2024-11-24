package me.devksh930.hr.infrastructure.command;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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

	@Query("""
		SELECT e 
		FROM Employee e
		       JOIN FETCH e.job 
		       JOIN FETCH e.manager 
		       JOIN FETCH e.department d 
		WHERE d.departmentId = :departmentId
		""")
	List<Employee> findByDepartmentId(Integer departmentId);

	@Modifying
	@Query("""
		UPDATE Employee e 
		SET e.salary = e.salary * :incrementFactor 
		WHERE e.employeeId IN :employeeIds
		""")
	int updateSalaryByEmployeeIds(
		@Param("employeeIds") List<Integer> employeeIds,
		@Param("incrementFactor") BigDecimal incrementFactor
	);
}
