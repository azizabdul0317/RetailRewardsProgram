package com.retail.rewards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * The main class of the Retail Application.
 * This class is responsible for initializing and launching the Spring Boot application.
 */
@SpringBootApplication
public class RetailApplication {

    /**
     * The entry point of the Retail Application.
     *
     * @param args The command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        SpringApplication.run(RetailApplication.class, args);
    }
}
