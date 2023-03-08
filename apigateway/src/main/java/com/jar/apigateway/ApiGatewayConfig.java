package com.jar.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig {
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {

		/*Function<PredicateSpec, Buildable<Route>> routeFunction = p -> p.path("/get").filters(
				f -> f.addRequestHeader("JayHeader", "ValueHeader").addRequestParameter("JayParam", "ValueParam"))
				.uri("http://httpbin.org:80");

		return builder.routes().route(routeFunction).build();*/
		return builder.routes()
				.route(p -> p.path("/currency-conversion/**").uri("lb://currency-conversion"))
				.route(p -> p.path("/currency-exchange/**").uri("lb://currency-exchange"))
				.route(p -> p.path("/currency-conversion-feign/**").uri("lb://currency-conversion-feign"))
				.build();
	}
}
