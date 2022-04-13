package com.mtsaldaris.addressbook.repository;

import com.mtsaldaris.addressbook.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
    StudentRepository Interface:
     - Acts as Data Access Layer to allow for CRUD operations
     - Spring Data repository abstraction significantly reduces amount of boilerplate code
 */
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
