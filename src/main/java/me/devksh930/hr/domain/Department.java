package me.devksh930.hr.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(
	name = "departments",
	indexes = {
		@Index(name = "idx_departments_location_id", columnList = "location_id"),
		@Index(name = "idx_departments_manager_id", columnList = "manager_id")
	}
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Department {

	@Id
	private Integer departmentId;

	private String departmentName;

	@ManyToOne
	@JoinColumn(name = "manager_id")
	private Employee manager;

	@ManyToOne
	@JoinColumn(name = "location_id", nullable = false)
	private Location location;

	public Department(
		final Integer departmentId,
		final String departmentName,
		final Employee manager,
		final Location location
	) {
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.manager = manager;
		this.location = location;
	}
}