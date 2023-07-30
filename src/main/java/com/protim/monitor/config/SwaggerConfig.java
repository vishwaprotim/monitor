package com.protim.monitor.config;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


/**
 * This configuration uses Swagger3 with OpenAPI specification.<br>
 * For more information on Swagger using Open API, check
 * <a href="https://springdoc.org/#spring-data-rest-support">this</a>.<br>
 *
 * @author vishwaprotim
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Student API")
                        .description("A simple API using Spring Data REST")
                        .version("v0.0.1"))
                .externalDocs(new ExternalDocumentation()
                        .description("Check the github repository for more details")
                        .url("https://github.com/vishwaprotim/monitor"))
                .tags(List.of(new Tag()
                        .name("Student API")
                        .description("Simple Student Entity API using Spring Data REST")
                        .externalDocs(new ExternalDocumentation()
                                .description("Check the Spring Data REST Documentation here")
                                .url("https://docs.spring.io/spring-data/rest/docs/current/reference/html/"))));
    }

}



