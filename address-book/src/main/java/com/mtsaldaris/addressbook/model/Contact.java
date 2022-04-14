package com.mtsaldaris.addressbook.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


import java.util.Objects;

import static javax.persistence.GenerationType.SEQUENCE;
/*
    Contact class
     - Contains the Contact model
     - Model is mapped to a database table using @Entity annotation
 */

@Entity(name = "Contact")
@Table(name = "AddressBook")
public class Contact {
    // Use @Id annotation to signify that "id" is the primary key
    @Id

    // Configure sequence with an increment valuer of 1 on specified Id
    @SequenceGenerator(
            name = "contact_sequence",
            sequenceName = "contact_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "contact_sequence"
    )

    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    // Ensure value is not null and not just white space
    @NotBlank(message = "First name is required")
    // Validate name is alphanumeric and can have hyphen or space
    @Pattern(regexp = "^[a-zA-Z0-9\\- ]*$", message = "Name must be alphanumeric, can contain hyphen & space")
    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    // Ensure value is not null and not just white space
    @NotBlank(message = "Phone number is required")
    // Validate phone number
    @Column(
            name = "phone_number",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String phoneNumber;

    // Empty constructor
    public Contact() {
    }

    public Contact(String name,
                   String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // To string


    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

}
