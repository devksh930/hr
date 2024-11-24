package me.devksh930.hr.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manager_id")
	private Employee manager;

	@ManyToOne(fetch = FetchType.LAZY)
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

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		final Department that = (Department)o;
		return departmentId.equals(that.departmentId);
	}

	@Override
	public int hashCode() {
		return departmentId.hashCode();
	}
}