package com.alura.ProjetoAcelera.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfigurations {

	@Bean
	public Docket carangoBomApi() {
		return new Docket(DocumentationType.OAS_30)
				.apiInfo(new ApiInfoBuilder()
						.title("Carango Bom API")
						.description("A CRUD API to demonstrate Springfox 3 integration")
						.version("0.0.1-SNAPSHOT")
						.license("MIT")
						.licenseUrl("https://opensource.org/licenses/MIT")
						.build())
				.select().apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				.build();

//				.select()
//				.apis(RequestHandlerSelectors.basePackage("com.alura.ProjetoAcelera"))
//				.paths(PathSelectors.ant("/**"))
//				.build()
//				.ignoredParameterTypes(User.class);
	}
}
