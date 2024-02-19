package br.com.crudApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Used stacks:
 * - Spring Initializr
 * - Spring Data JPA
 * - Spring Web
 * - H2 Database
 * - OpenFeign
 * - Lombok
 * - DevTools
 * - Swagger (OpenAPI)
 *
 * @author maxjdev
 */

@EnableFeignClients
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
