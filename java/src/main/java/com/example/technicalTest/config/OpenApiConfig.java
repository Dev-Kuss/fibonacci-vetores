package com.example.technicalTest.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Faturamento")
                        .version("1.0")
                        .description("API para gerenciamento de faturamento diário"));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("faturamento")
                .pathsToMatch("/api/faturamento/**")
                .packagesToScan("com.example.technicalTest.controller")
                .build();
    }
}
