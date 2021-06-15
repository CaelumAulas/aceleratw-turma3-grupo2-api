package com.alura.ProjetoAcelera.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.service.ParameterType;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;

@Configuration
public class SwaggerConfigurations {

	@Bean
	public Docket carangoBomApi() {
		return new Docket(DocumentationType.OAS_30)
				.apiInfo(new ApiInfoBuilder()
						.title("Carango Bom API")
						.description("Uma API REST do projeto Acelera. Grupo 2 " +
								"(Bianca Veronezi/Ingrid Vaz/Luíza Abreu/Ronaldo Caetano/Wendel Macedo)")
						.version("0.0.1-SNAPSHOT")
						.license("MIT")
						.licenseUrl("https://opensource.org/licenses/MIT")
						.build())
				.select().apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				.build().globalRequestParameters(Arrays.asList(
						new RequestParameterBuilder().name("Authorization")
								.description("Authorization details for security JWT token")
								.in(ParameterType.HEADER).required(false).build()));
	}
}
