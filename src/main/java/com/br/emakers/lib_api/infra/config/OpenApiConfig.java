package com.br.emakers.lib_api.infra.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Configuration
public class OpenApiConfig{

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("RESTful API with Java 21 and Spring Boot 3")
                        .version("v1")
                        .description("A RESTful API for a library that provides user registration, book registration and borrowing books.")
                )
                .servers(Arrays.asList(
                        new Server().url("https://localhost:8080").description("Local server")
                ));
    }

}
