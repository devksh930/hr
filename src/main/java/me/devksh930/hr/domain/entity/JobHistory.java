package me.devksh930.hr.domain.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(
	name = "job_history",
	uniqueConstraints = {
		@UniqueConstraint(name = "uk_job_history_employee_start_date", columnNames = {"employee_id", "start_date"})
	}
)
@IdClass(JobHistoryId.class)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class JobHistory {

	@Id
	@ManyToOne
	@JoinColumn(name = "employee_id", nullable = false)
	private Employee employee;

	@Id
	private LocalDate startDate;

	private LocalDate endDate;

	@ManyToOne
	@JoinColumn(name = "job_id", nullable = false)
	private Job job;

	@ManyToOne
	@JoinColumn(name = "department_id", nullable = false)
	private Department department;

	public JobHistory(
		final Employee employee,
		final LocalDate startDate,
		final LocalDate endDate,
		final Job job,
		final Department department
	) {
		this.employee = employee;
		this.startDate = startDate;
		this.endDate = endDate;
		this.job = job;
		this.department = department;
	}
}
