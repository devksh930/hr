package me.devksh930.hr.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LotterySalesReportQuery(
	@JsonProperty("구분") String category,
	@JsonProperty("연도") int year,
	@JsonProperty("온라인복권(억원)") int onlineLottery,
	@JsonProperty("전년대비증감률") String growthRate,
	@JsonProperty("전자복권(억원)") int electronicLottery,
	@JsonProperty("즉석식인쇄복권(억원)") int instantLottery,
	@JsonProperty("추첨식결합복권(억원)") int combinedLottery,
	@JsonProperty("합 계(억원)") int totalAmount
) {
}
