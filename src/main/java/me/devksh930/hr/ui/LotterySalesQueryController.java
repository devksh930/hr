package me.devksh930.hr.ui;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import me.devksh930.hr.common.response.DataGovernmentApiResponse;
import me.devksh930.hr.domain.model.LotterySalesReportQuery;
import me.devksh930.hr.infrastructure.client.LotterySalesClient;

@RestController
@RequestMapping("/lottery")
@RequiredArgsConstructor
public class LotterySalesQueryController {
	private final LotterySalesClient lotterySalesClient;

	@GetMapping("/sales-report")
	public DataGovernmentApiResponse<LotterySalesReportQuery> getLotterySaleReport(
		@RequestParam int page,
		@RequestParam int size
	) {

		return lotterySalesClient.getLotterySalesReport(page,
			size);
	}
}
