package com.mtsaldaris.addressbook.repository;

import com.mtsaldaris.addressbook.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
    StudentRepository Interface:
     - Extends JpaRepository
     - Spring Data repository abstraction significantly reduces amount of boilerplate code
     - Acts as Data Access Layer to allow for CRUD operations
 */
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
