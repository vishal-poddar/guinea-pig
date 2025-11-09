package com.example.guineapig.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Guinea Pig API")
                        .version("1.0.0")
                        .description("A simple Spring Boot application with test API and Swagger documentation for Backstage integration")
                        .contact(new Contact()
                                .name("Guinea Pig Team")
                                .url("https://github.com/vishal-poddar/guinea-pig")));
    }
}
