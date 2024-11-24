package me.devksh930.hr.infrastructure.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import me.devksh930.hr.common.config.DataGovernmentFeignClientConfig;
import me.devksh930.hr.common.response.DataGovernmentApiResponse;
import me.devksh930.hr.domain.model.LotterySalesReportQuery;

@FeignClient(
	name = "data-government-api",
	url = "https://api.odcloud.kr",
	configuration = {DataGovernmentFeignClientConfig.class})
public interface LotterySalesClient {

	@GetMapping("/api/15088747/v1/uddi:7abe83b2-2193-4d12-b853-b143f17239da")
	DataGovernmentApiResponse<LotterySalesReportQuery> getLotterySalesReport(
		@RequestParam("page") int page,
		@RequestParam("perPage") int size
	);
}