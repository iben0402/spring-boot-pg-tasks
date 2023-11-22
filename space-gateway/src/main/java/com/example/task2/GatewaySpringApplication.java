package com.example.task2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewaySpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewaySpringApplication.class, args);
	}


	@Bean
	public RouteLocator routeLocator(
			RouteLocatorBuilder builder,
			@Value("${space.astronaut.url}") String astronautUrl,
			@Value("${space.spaceship.url}") String spaceshipUrl,
			@Value("${space.gateway.url}") String host
	) {
		return builder
				.routes()
				.route("spaceships", route -> route
						.host(host)
						.and()
						.path(
								"/api/spaceship/{uuid}",
								"/api/spaceships"
						)
						.uri(spaceshipUrl)
				)
				.route("astronauts", route -> route
						.host(host)
						.and()
						.path(
								"/api/astronauts",
								"/api/astronauts/**",
								"/api/spaceships/{uuid}/astronauts",
								"/api/spaceships/{uuid}/astronauts/**"
						)
						.uri(astronautUrl)
				)
				.build();
	}

}
