package com.productsapi.productsapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.RelativePathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;

import javax.servlet.ServletContext;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket productApi(ServletContext servletContext) {
	    return new Docket(DocumentationType.SWAGGER_2)
    		.pathProvider(new RelativePathProvider(servletContext) {
    			@Override
    			public String getApplicationBasePath() {
    				return "/api" + super.getApplicationBasePath();
    			}})
    		.host("proxyURL")
    		.apiInfo(metaInfo());
	}
	
	private ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo(
			"Products API Rest",
			"API Rest for products.",
			"1.0",
			"Terms of Service",
			new Contact("Felipe Guimarães", "felipeaggs@gmail.com", null),
			"Apache License Version 2.0",
			"https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
		);
		
		return apiInfo;
	}
	
}
