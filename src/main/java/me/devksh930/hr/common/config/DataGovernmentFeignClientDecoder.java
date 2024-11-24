package me.devksh930.hr.common.config;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import me.devksh930.hr.exception.ExternalApiException;

@Slf4j
public class DataGovernmentFeignClientDecoder implements ErrorDecoder {

	@Override
	public Exception decode(
		final String s,
		final Response response
	) {
		log.error("====================================================");
		log.error(response.body().toString());
		log.error(response.request().url().toString());
		log.error(s);
		log.error("====================================================");
		return new ExternalApiException();
	}
}
