package me.devksh930.hr.domain.entity;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class JobHistoryId implements Serializable {
	private Integer employee;
	private LocalDate startDate;

	public JobHistoryId(
		final Integer employee,
		final LocalDate startDate
	) {
		this.employee = employee;
		this.startDate = startDate;
	}
}