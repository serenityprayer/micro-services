package com.github.serenity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public AccessZuulFilter accessZuulFilter() {
		return new AccessZuulFilter();
	}

	@Bean
	public CustomFallbackProvider customFallbackProvider() { return new CustomFallbackProvider(); }
}
