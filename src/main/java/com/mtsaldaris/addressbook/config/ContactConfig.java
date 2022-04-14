package com.mtsaldaris.addressbook.config;

import com.mtsaldaris.addressbook.model.Contact;
import com.mtsaldaris.addressbook.repository.ContactRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ContactConfig {

    // Seed the db with some initial contact data
    @Bean
    CommandLineRunner commandLineRunner(ContactRepository repository) {
        return args -> {
            Contact myron = new Contact(
                    "Myron T",
                    "0422123456"
            );

            Contact fred = new Contact(
                    "Fred Jones",
                    "0412345678"
            );

            Contact bob = new Contact(
                    "Bob Smith",
                    "0412345678"
            );

            repository.saveAll(
                    List.of(myron, bob, fred)
            );
        };
    }
}
