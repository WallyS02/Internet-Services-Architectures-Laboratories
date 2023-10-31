package com.example.music;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayMusicApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayMusicApplication.class, args);
	}

	@Bean
	public RouteLocator routeLocator(
			RouteLocatorBuilder builder,
			@Value("${music.musician.url}") String musicianUrl,
			@Value("${music.instrument.url}") String instrumentUrl,
			@Value("${music.gateway.host}") String host
	) {
		return builder
				.routes()
				.route("instruments", route -> route
						.host(host)
						.and()
						.path(
								"/api/instruments/{uuid}",
								"/api/instruments"
						)
						.uri(instrumentUrl)
				)
				.route("musicians", route -> route
						.host(host)
						.and()
						.path(
								"/api/musicians",
								"/api/musicians/**",
								"/api/instruments/{uuid}/musicians",
								"/api/instruments/{uuid}/musicians/**"
						)
						.uri(musicianUrl)
				)
				.build();
	}
}
