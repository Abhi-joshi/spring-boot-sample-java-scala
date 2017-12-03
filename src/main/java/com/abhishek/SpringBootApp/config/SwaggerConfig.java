package com.abhishek.SpringBootApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket customerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.abhishek.SpringBootApp.controller"))
                .paths(regex("/customer.*"))
                .build()
                .apiInfo(metaData());
    }
    private ApiInfo metaData() {
    	return new ApiInfoBuilder()
                .title("Customer Details")
                .description("Spring Boot REST API for Customer Details")
                .version("1.0.0")
                .termsOfServiceUrl("Terms of service")
                .contact(new Contact("Abhishek Sharma", "https://github.com/Abhi-joshi", "mail.abhishekjoshi@gmail.com"))
                .build();
    }
}
