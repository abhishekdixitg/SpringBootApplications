package com.example.SpringBootDemo;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
@Configuration
public class GatewayConfig {

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		String productServiceUri = System.getenv().getOrDefault("PRODUCT_SERVICE_URI", "http://localhost:8096");

		return builder.routes()
				.route("product-service",
						r -> r.path("/products/**")
								.filters(f -> f.rewritePath("/products/?(?<segment>.*)", "/products/$\\{segment}"))
								.uri(productServiceUri))
				.build();
	}
}*/