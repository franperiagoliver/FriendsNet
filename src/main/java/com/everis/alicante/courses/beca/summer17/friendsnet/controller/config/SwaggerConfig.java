/*
 * Created at 24-ago-2017 by Fran Periago
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.controller.config;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The Class SwaggerConfig.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/** The logger. */
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * Inits the.
	 */
	@PostConstruct
	public void init() {
		logger.info("Initializing SwaggerConfig...");
	}

	/**
	 * Api.
	 *
	 * @return the docket
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors
						.basePackage("com.everis.alicante.courses.beca.summer17.friendsnet.controller"))
				.paths(PathSelectors.any()).build().apiInfo(apiInfo());
	}

	/**
	 * Api info.
	 *
	 * @return the api info
	 */
	private ApiInfo apiInfo() {
		return new ApiInfo("FriendsNet Application REST API",
				"The API exposes common functionallities to manage the FriendsNet", "Version 0.1", "Terms of service",
				new Contact("Fran Periago", "franperiagoliver.com", "franperiagoliver@gmail.com"),
				"Creative Commons NoCommercial-Atributtion 4.0 Internacional",
				"http://creativecommons.org/licenses/by-nc/4.0/");
	}
}