package me.devksh930.hr.domain.entity;

import java.time.LocalDate;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
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
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class JobHistory {

	@EmbeddedId
	private JobHistoryId id;

	private LocalDate endDate;

	@ManyToOne
	@JoinColumn(name = "job_id", nullable = false)
	private Job job;

	@ManyToOne
	@JoinColumn(name = "department_id", nullable = false)
	private Department department;

	public JobHistory(
		final Integer employeeId,
		final LocalDate startDate,
		final LocalDate endDate,
		final Job job,
		final Department department
	) {
		this.id = new JobHistoryId(
			employeeId,
			startDate
		);
		this.endDate = endDate;
		this.job = job;
		this.department = department;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		final JobHistory that = (JobHistory)o;
		return id.equals(that.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}
}