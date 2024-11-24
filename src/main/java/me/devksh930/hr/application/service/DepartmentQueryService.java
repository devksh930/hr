package me.devksh930.hr.application.service;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import me.devksh930.hr.application.mapper.DepartmentMapper;
import me.devksh930.hr.common.util.PagingUtils;
import me.devksh930.hr.dto.response.DepartmentResponse;
import me.devksh930.hr.infrastructure.query.DepartmentQueryDao;

@Service
@RequiredArgsConstructor
public class DepartmentQueryService {
	private final DepartmentQueryDao departmentQueryDao;
	private final DepartmentMapper departmentMapper;

	public PageImpl<DepartmentResponse> queryDepartmentWithPaging(final PageRequest pageRequest) {
		departmentQueryDao.queryDepartmentWithPaging(
			pageRequest.getPageSize(),
			pageRequest.getOffset()
		);
		return PagingUtils.fetchPage(
			() -> departmentQueryDao.queryDepartmentWithPaging(
					pageRequest.getPageSize(),
					pageRequest.getOffset()
				)
				.stream().map(departmentMapper::departmentQueryToResponse)
				.toList(),
			pageRequest,
			departmentQueryDao.departmentCount()
		);
	}
}
