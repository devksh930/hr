package me.devksh930.hr.domain.entity;

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

	@Column(nullable = false)
	private Double minSalary;

	@Column(nullable = false)
	private Double maxSalary;

	public Job(
		final String jobId,
		final String jobTitle,
		final Double minSalary,
		final Double maxSalary
	) {
		this.jobId = jobId;
		this.jobTitle = jobTitle;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
	}
}
