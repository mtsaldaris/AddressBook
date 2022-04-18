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
    @Pattern(regexp = "^[a-zA-Z0-9\\- ]*$", message = "First name must be alphanumeric, can contain hyphen & space")
    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstName;

    // Ensure value is not null and not just white space
    @NotBlank(message = "Last name is required")
    // Validate name is alphanumeric and can have hyphen or space
    @Pattern(regexp = "^[a-zA-Z0-9\\- ]*$", message = "Last name must be alphanumeric, can contain hyphen & space")
    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastName;

    // Ensure value is not null and not just white space
    @NotBlank(message = "Phone number is required")
    // Validate phone number is numeric - up to 11 digits and can include a plus symbol (e.g. +61422169922)
    @Pattern(regexp= "^\\+?[0-9]{7,}$", message = "Please enter a valid phone number")
    @Column(
            name = "phone_number",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String phoneNumber;

    // Empty constructor
    public Contact() {
    }

    public Contact(String firstName,
                   String lastName,
                   String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

}
