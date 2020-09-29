package com.capgemini.go;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@ComponentScan("com.capgemini.go")
public class RetailerManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetailerManagementServiceApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.capgemini.go")).paths(PathSelectors.any()).build()
				.apiInfo(myApiInfo());

	}

	private ApiInfo myApiInfo() {
		return new ApiInfo("Retailer Management service API", "Add,update,delete and fetchs  the retailer details.",
				"1.0", "Free to Use", new Contact("Ashish Verma", "/api", "ashishverma792@gmail.com"), "API licence",
				"/api", Collections.emptyList());
	}

	@Bean
	public MethodValidationPostProcessor methodValidationPostProcessor() {
		return new MethodValidationPostProcessor();
	}
}
