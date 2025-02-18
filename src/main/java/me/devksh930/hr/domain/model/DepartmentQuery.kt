package me.devksh930.hr.domain.model;

public record DepartmentQuery(
	Integer departmentId,
	String departmentName,
	Integer manageId,
	Integer locationId,
	String streetAddress,
	String postalCode,
	String city,
	String stateProvince,
	String countryId,
	String countryName,
	Integer regionId,
	String regionName
) {
}
