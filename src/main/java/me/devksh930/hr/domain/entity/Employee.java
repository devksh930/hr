package me.devksh930.hr.domain.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(
	name = "employees",
	uniqueConstraints = {
		@UniqueConstraint(name = "uk_employees_email", columnNames = "email")
	},
	indexes = {
		@Index(name = "idx_employees_department_id", columnList = "department_id"),
		@Index(name = "idx_employees_manager_id", columnList = "manager_id"),
		@Index(name = "idx_employees_job_id", columnList = "job_id")
	}
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Employee {

	@Id
	private Integer employeeId;

	private String firstName;
	private String lastName;

	@Column(nullable = false, unique = true)
	private String email;

	private String phoneNumber;

	private LocalDate hireDate;

	@ManyToOne
	@JoinColumn(name = "job_id", nullable = false)
	private Job job;

	@Column(nullable = false)
	private Double salary;

	private Double commissionPct;

	@ManyToOne
	@JoinColumn(name = "manager_id")
	private Employee manager;

	@ManyToOne
	@JoinColumn(name = "department_id", nullable = false)
	private Department department;

	public Employee(
		final Integer employeeId,
		final String firstName,
		final String lastName,
		final String email,
		final String phoneNumber,
		final LocalDate hireDate,
		final Job job,
		final Double salary,
		final Double commissionPct,
		final Employee manager,
		final Department department
	) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
		this.job = job;
		this.salary = salary;
		this.commissionPct = commissionPct;
		this.manager = manager;
		this.department = department;
	}
}