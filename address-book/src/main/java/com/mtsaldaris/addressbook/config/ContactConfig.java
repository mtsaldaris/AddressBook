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
                    "Myron",
                    "Tsaldaris",
                    "0422123456"
            );
            Contact fred = new Contact(
                    "Fred",
                    "Jones",
                    "0412345678"
            );
            Contact bob = new Contact(
                    "Bob",
                    "Smith",
                    "+61422345678"
            );
            Contact tom = new Contact(
                    "Tom",
                    "Jackson",
                    "0412345678"
            );
            Contact garry = new Contact(
                    "Garry",
                    "Davis",
                    "+61422654989"
            );
            Contact mary = new Contact(
                    "Mary",
                    "South",
                    "0412745679"
            );
             Contact sarah = new Contact(
                    "Sarah",
                    "Mason",
                    "+614365879"
            );


            repository.saveAll(
                    List.of(myron, bob, fred, tom, garry, mary, sarah)
            );
        };
    }
}
