package me.devksh930.hr.dto.response;

public record DepartmentResponse(
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
