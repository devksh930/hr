package me.devksh930.hr.application.service;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import me.devksh930.hr.application.mapper.EmployeeMapper;
import me.devksh930.hr.common.util.PagingUtils;
import me.devksh930.hr.dto.response.EmployeeQueryResponse;
import me.devksh930.hr.infrastructure.query.EmployeeQueryDao;

@Service
@RequiredArgsConstructor
public class EmployeeQueryService {
	private final EmployeeQueryDao employeeQueryDao;
	private final EmployeeMapper employeeMapper;

	@Transactional(readOnly = true)
	public PageImpl<EmployeeQueryResponse> queryEmployee(
		final PageRequest pageRequest
	) {
		return PagingUtils.fetchPage(
			() -> employeeQueryDao.findEmployeePaged(pageRequest)
				.stream()
				.map(employeeMapper::employeeQueryToResponse)
				.toList(),
			pageRequest,
			employeeQueryDao.countEmployee()
		);
	}
}
