package me.devksh930.hr.application.mapper;

import org.springframework.stereotype.Component;

import me.devksh930.hr.domain.model.DepartmentQuery;
import me.devksh930.hr.dto.response.DepartmentResponse;

@Component
public class DepartmentMapper {

	public DepartmentResponse departmentQueryToResponse(
		DepartmentQuery model
	) {
		return new DepartmentResponse(
			model.departmentId(),
			model.departmentName(),
			model.manageId(),
			model.locationId(),
			model.streetAddress(),
			model.postalCode(),
			model.city(),
			model.stateProvince(),
			model.countryId(),
			model.countryName(),
			model.regionId(),
			model.regionName()
		);
	}
}
