package me.devksh930.hr.common.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "me.devksh930.hr.infrastructure.client")
public class FeignClientConfig {
}
