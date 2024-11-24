package me.devksh930.hr.application.service;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import me.devksh930.hr.application.mapper.LotterySalesMapper;
import me.devksh930.hr.common.response.DataGovernmentApiResponse;
import me.devksh930.hr.domain.model.LotterySalesReportQuery;
import me.devksh930.hr.dto.response.LotterySaleReportResponse;
import me.devksh930.hr.infrastructure.client.LotterySalesClient;

@Service
@RequiredArgsConstructor
public class LotterySaleQueryService {
	private final LotterySalesClient lotterySalesClient;
	private final LotterySalesMapper lotterySalesMapper;

	public PageImpl<LotterySaleReportResponse> queryLotteryReport(
		final PageRequest pageRequest
	) {

		final DataGovernmentApiResponse<LotterySalesReportQuery> response = lotterySalesClient.getLotterySalesReport(
			pageRequest.getPageSize(),
			pageRequest.getPageSize()
		);

		return new PageImpl<LotterySaleReportResponse>(
			response.data()
				.stream().map(lotterySalesMapper::lotterySalesReportQueryToResponse)
				.toList(),
			pageRequest,
			response.totalCount()
		);
	}
}
