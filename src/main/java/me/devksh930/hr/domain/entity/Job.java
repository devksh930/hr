package me.devksh930.hr.domain.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(
	name = "jobs"
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Job {

	@Id
	private String jobId;

	private String jobTitle;

	@Column(name = "min_salary", columnDefinition = "DECIMAL")
	private BigDecimal minSalary;

	@Column(name = "max_salary", columnDefinition = "DECIMAL")
	private BigDecimal maxSalary;

	public Job(
		final String jobId,
		final String jobTitle,
		final BigDecimal minSalary,
		final BigDecimal maxSalary
	) {
		this.jobId = jobId;
		this.jobTitle = jobTitle;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		final Job job = (Job)o;
		return jobId.equals(job.jobId);
	}

	@Override
	public int hashCode() {
		return jobId.hashCode();
	}

	public boolean isSalaryAboveMin(BigDecimal salary) {
		return salary.compareTo(minSalary) >= 0;
	}

	public boolean isSalaryBelowMax(BigDecimal salary) {
		return salary.compareTo(maxSalary) <= 0;
	}

	public boolean isWithinRange(BigDecimal salary) {
		return isSalaryAboveMin(salary) && isSalaryBelowMax(salary);
	}

}
