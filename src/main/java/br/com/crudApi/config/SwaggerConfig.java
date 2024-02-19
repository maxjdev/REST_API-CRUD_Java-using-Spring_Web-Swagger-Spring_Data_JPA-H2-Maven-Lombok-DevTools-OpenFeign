package br.com.crudApi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author maxjdev
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API REST - Java CRUD using H2 DataBase, Lombok, Swagger, OpenFeign, Spring Boot, Spring Web and Spring Data JPA")
                        .version("1.0.0")
                        .description("API to perform CRUD operations on users with name and email.")
                        .termsOfService("Open-Source")
                        .license(new License().name("MIT License").url(" https://opensource.org/licenses/MIT"))
                        .contact(new Contact().name("maxjdev").email("maxjramosdev@gmail.com").url("https://www.linkedin.com/in/maxjdev/"))
                );
    }
}