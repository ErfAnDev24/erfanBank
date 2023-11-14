package com.example.getwayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class GetwayserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetwayserverApplication.class, args);
	}

	@Bean
	public RouteLocator erfanBankRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
		return routeLocatorBuilder.routes()
				.route(p->p
						.path("erfanbank/accounts/**")
						.filters(f->f.rewritePath("erfanbank/accounts/?<segment>.*","${segment}")
								.addResponseHeader("X-Response-Time",LocalDateTime.now().toString()))
						.uri("lb://ACCOUNTS"))

				.route(p->p.path("erfanbank/loans/**")
						.filters(f->f.rewritePath("erfanbank/loans/?<segment>.*","${segment}")
								.addResponseHeader("X-Response-Time",LocalDateTime.now().toString()))
						.uri("lb://LOANS"))

				.route(p->p.path("erfanbank/cards/**")
						.filters(f->f.rewritePath("erfanbank/cards/?<segment>.*","${segment}")
								.addResponseHeader("X-Response-Time",LocalDateTime.now().toString()))
						.uri("lb://CARDS")).build();
	}
}
