package com.qsp.flight_management_system.util; 

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Flight Management System")
                        .description("The Flight Management System is designed to streamline airline operations, "
                                + "providing functionalities for managing flights, passengers, bookings, and other airport-related services. "
                                + "This system enhances efficiency in airline management by integrating real-time data handling and secure access "
                                + "to essential flight-related information. \n\n"
                                + "Features:\n"
                                + "- Flight scheduling and real-time updates\n"
                                + "- Passenger and crew management\n"
                                + "- Secure booking and ticketing system\n"
                                + "- Baggage and cargo tracking\n"
                                + "- Airport services integration\n"
                                + "- RESTful API with Swagger documentation for seamless interaction\n\n"
                                + "This system provides a seamless experience for flight check-in, tracking, and various airport services, both online and offline.")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Shiva prasad")
                                .email("aroorishivaprasad@gmail.com"))
                        .license(new License()
                                .name("License")
                                .url("#")));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .packagesToScan("com.qsp.flight_management_system")
                .build();
    }
}
