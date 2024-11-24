package me.devksh930.hr.application.mapper;

import org.springframework.stereotype.Component;

import me.devksh930.hr.domain.model.LotterySalesReportQuery;
import me.devksh930.hr.dto.response.LotterySaleReportResponse;

@Component
public class LotterySalesMapper {
	public LotterySaleReportResponse lotterySalesReportQueryToResponse(
		final LotterySalesReportQuery model
	) {
		return new LotterySaleReportResponse(
			model.category(),
			model.year(),
			model.onlineLottery(),
			model.growthRate(),
			model.electronicLottery(),
			model.instantLottery(),
			model.combinedLottery(),
			model.totalAmount()
		);
	}
}
