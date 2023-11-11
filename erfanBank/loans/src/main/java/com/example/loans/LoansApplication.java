package com.example.loans;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Loans REST APIs"
				,description = "This is a documentation for CRUD Operations for Loans microservice"
				,version = "v1"
				,contact = @Contact(
						name = "ErfAn Pezeshkpour",
				email = "erfan01724@gmail.com",
				url = "www.erfan-pezeshkpour.com"
		)
				,license = @License(name = "Apache 2.0" ,
		url = "https://www.google.com")
		)
		,externalDocs = @ExternalDocumentation(url = "www.erfan-pezeshkpour.com" , description = "for more details")
)
public class LoansApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoansApplication.class, args);
	}

}
