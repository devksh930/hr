package me.devksh930.hr.application.service;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import me.devksh930.hr.application.mapper.EmployeeHistoryMapper;
import me.devksh930.hr.common.util.PagingUtils;
import me.devksh930.hr.dto.response.EmployeeJobHistoryResponse;
import me.devksh930.hr.infrastructure.query.EmployeeHistoryQueryDao;

@Service
@RequiredArgsConstructor
public class EmployeeHistoryQueryService {
	private final EmployeeHistoryQueryDao employeeHistoryQueryDao;
	private final EmployeeHistoryMapper employeeHistoryMapper;

	public PageImpl<EmployeeJobHistoryResponse> queryEmployeeJobHistory(
		final Integer employeeId,
		final PageRequest pageRequest
	) {
		return PagingUtils.fetchPage(
			() -> employeeHistoryQueryDao.findJobHistoryByEmployeeId(
					employeeId,
					pageRequest
				)
				.stream()
				.map(employeeHistoryMapper::employeeHistoryQueryToResponse)
				.toList(),
			pageRequest,
			employeeHistoryQueryDao.countJobHistoryByEmployeeId(employeeId)
		);
	}

}
