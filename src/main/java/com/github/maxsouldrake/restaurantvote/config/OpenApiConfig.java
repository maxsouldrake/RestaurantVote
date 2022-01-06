package com.github.maxsouldrake.restaurantvote.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        name = "basicAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "basic")
@OpenAPIDefinition(
        info = @Info(
                title = "REST API documentation",
                version = "1.0",
                description = """
                        Spring Boot test application. Restaurant voting system
                        <p><b>Test credentials:</b><br>
                        - user1@gmail.com / user1pass<br>
                        - user2@gmail.com / user2pass<br>
                        - admin@gmail.com / adminpass</p>
                        """),
        security = @SecurityRequirement(name = "basicAuth"))
public class OpenApiConfig {

    @Bean
    public GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .group("REST API")
                .pathsToMatch("/restaurant-vote/**")
                .build();
    }
}
