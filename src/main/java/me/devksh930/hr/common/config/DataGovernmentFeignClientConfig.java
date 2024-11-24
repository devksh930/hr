package me.devksh930.hr.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import feign.Logger;
import feign.RequestInterceptor;

public class DataGovernmentFeignClientConfig {

	@Value("${feign.client.service-key:defautl-key}")
	private String serviceKey;


	@Bean
	public DataGovernmentFeignClientDecoder dataGovernmentFeignClientDecoder() {
		return new DataGovernmentFeignClientDecoder();
	}

	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}
	@Bean
	public RequestInterceptor requestInterceptor() {
		return requestTemplate -> requestTemplate.query("serviceKey", serviceKey);
	}
}
