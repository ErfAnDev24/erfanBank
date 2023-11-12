package com.example.cards;

import com.example.cards.dto.CardsContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableConfigurationProperties(value = CardsContactInfoDto.class)
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Cards Microservice APIs",
				description = "Documentation for Cards Microservice APIs in ErfAn Bank",
				version = "v1",
				contact = @Contact(
						name = "ErfAn Pezeshkpour",
						email = "erfan01724@gmail.com",
						url = "https://www.google.com"
				),
				license = @License(
						name = "Apache 2.0"
						,url = "https://www.google.com"
				)
		)
		,externalDocs = @ExternalDocumentation(
				url = "https://www.google.com",
				description = "If you're looking for a more details click here")
		)
public class CardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsApplication.class, args);
	}

}
