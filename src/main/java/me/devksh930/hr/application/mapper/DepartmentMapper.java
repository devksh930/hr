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
			model.getDepartmentId(),
			model.getDepartmentName(),
			model.getManageId(),
			model.getLocationId(),
			model.getStreetAddress(),
			model.getPostalCode(),
			model.getCity(),
			model.getStateProvince(),
			model.getCountryId(),
			model.getCountryName(),
			model.getRegionId(),
			model.getRegionName()
		);
	}
}
