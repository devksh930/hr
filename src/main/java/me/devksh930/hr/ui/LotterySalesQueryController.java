package me.devksh930.hr.ui;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import me.devksh930.hr.application.service.LotterySaleQueryService;
import me.devksh930.hr.dto.response.LotterySaleReportResponse;

@RestController
@RequestMapping("/lottery")
@RequiredArgsConstructor
public class LotterySalesQueryController {
	private final LotterySaleQueryService lotterySaleQueryService;

	@GetMapping("/sales-report")
	public PageImpl<LotterySaleReportResponse> getLotterySaleReport(
		@RequestParam int page,
		@RequestParam int size
	) {
		return lotterySaleQueryService.queryLotteryReport(PageRequest.of(page,
			size));
	}
}
