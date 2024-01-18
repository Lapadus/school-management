package com.unibuc.fmi.schoolmanagement.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;

public class OpenApiConfig {
    @Bean
    public GroupedOpenApi customOpenAPI() {
        return GroupedOpenApi.builder()
                .group("spring")
                .packagesToScan("com.unibuc.fmi.schoolmanagement.controller")
                .build();
    }
}
