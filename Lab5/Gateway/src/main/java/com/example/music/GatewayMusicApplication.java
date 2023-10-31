package com.example.music;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

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

	@Bean
	public CorsWebFilter corsWebFilter() {
		final CorsConfiguration corsConfig = new CorsConfiguration();
		corsConfig.setAllowedOrigins(Collections.singletonList("*"));
		corsConfig.setMaxAge(3600L);
		corsConfig.setAllowedMethods(Arrays.asList("GET", "PATCH", "DELETE", "PUT"));
		corsConfig.addAllowedHeader("*");

		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfig);

		return new CorsWebFilter(source);
	}
}
