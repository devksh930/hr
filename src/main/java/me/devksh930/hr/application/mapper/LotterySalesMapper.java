package me.devksh930.hr.application.mapper;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import me.devksh930.hr.domain.model.LotterySalesReportQuery;
import me.devksh930.hr.dto.response.LotterySaleReportResponse;

@Slf4j
@Component
public class LotterySalesMapper {
	public LotterySaleReportResponse lotterySalesReportQueryToResponse(
		final LotterySalesReportQuery model
	) {
		return new LotterySaleReportResponse(
			model.getCategory(),
			model.getYear(),
			model.getOnlineLottery(),
			model.getGrowthRate(),
			model.getElectronicLottery(),
			model.getInstantLottery(),
			model.getCombinedLottery(),
			model.getTotalAmount()
		);
	}
}
