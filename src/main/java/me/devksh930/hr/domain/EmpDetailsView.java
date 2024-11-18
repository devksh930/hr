package me.devksh930.hr.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "emp_details_view")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EmpDetailsView {

	@Id
	private Integer employeeId;
	private String jobId;
	private Integer managerId;
	private Integer departmentId;
	private Integer locationId;
	private String countryId;
	private String firstName;
	private String lastName;
	private Double salary;
	private Double commissionPct;
	private String departmentName;
	private String jobTitle;
	private String city;
	private String stateProvince;
	private String countryName;
	private String regionName;

	public EmpDetailsView(
		final Integer employeeId,
		final String jobId,
		final Integer managerId,
		final Integer departmentId,
		final Integer locationId,
		final String countryId,
		final String firstName,
		final String lastName,
		final Double salary,
		final Double commissionPct,
		final String departmentName,
		final String jobTitle,
		final String city,
		final String stateProvince,
		final String countryName,
		final String regionName
	) {
		this.employeeId = employeeId;
		this.jobId = jobId;
		this.managerId = managerId;
		this.departmentId = departmentId;
		this.locationId = locationId;
		this.countryId = countryId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.commissionPct = commissionPct;
		this.departmentName = departmentName;
		this.jobTitle = jobTitle;
		this.city = city;
		this.stateProvince = stateProvince;
		this.countryName = countryName;
		this.regionName = regionName;
	}
}