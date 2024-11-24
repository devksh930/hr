package me.devksh930.hr.dto.response;

public record LotterySaleReportResponse(
	String category,
	int year,
	int onlineLottery,
	String growthRate,
	int electronicLottery,
	int instantLottery,
	int combinedLottery,
	int totalAmount
) {
}
