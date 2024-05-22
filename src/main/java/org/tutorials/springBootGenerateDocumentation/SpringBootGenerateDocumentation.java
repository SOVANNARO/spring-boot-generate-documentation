package org.tutorials.springBootGenerateDocumentation;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Spring Boot Generate Documentation",
                version = "1.0.0",
                description = "Spring Boot Generate Documentation",
                contact = @Contact(
                        name = "Sovannaro",
                        email = "sovannaro@gmail.com",
                        url = "naro.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "http://www.apache.org/licenses/LICENSE-2.0.html"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Spring Boot Generate Documentation",
                url = "https://github.com/sovannaro/spring-boot-generate-documentation"
        )
)
public class SpringBootGenerateDocumentation {

    // config mapper libraries
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootGenerateDocumentation.class, args);
    }

}
