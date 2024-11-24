package me.devksh930.hr.domain.entity;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class JobHistoryId implements Serializable {
	private Integer employeeId;
	private LocalDate startDate;

	public JobHistoryId(
		final Integer employeeId,
		final LocalDate startDate
	) {
		this.employeeId = employeeId;
		this.startDate = startDate;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		final JobHistoryId that = (JobHistoryId)o;
		return employeeId.equals(that.employeeId) && startDate.equals(that.startDate);
	}

	@Override
	public int hashCode() {
		int result = employeeId.hashCode();
		result = 31 * result + startDate.hashCode();
		return result;
	}
}