package com.maxi.backpatient.springdoc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SpringdocConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Patient managment system API")
                        .version("V 01")
                        .description("API to manage and administrate patient regist system.")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://www.springdoc.org"))
                        .contact(new Contact()
                                .name("Amikel Maxi")
                                .email("maxloversist@gmail.com")
                                .url("http://www.facebook.com/maxiamikel")

                        )

                );
    }
}
