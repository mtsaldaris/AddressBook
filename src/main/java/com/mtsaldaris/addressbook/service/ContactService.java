package com.mtsaldaris.addressbook.service;

import com.mtsaldaris.addressbook.model.Contact;
import com.mtsaldaris.addressbook.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
    Contact Service class
     - Acts as the Service layer - responsible for business logic
     - Serves Data up to the API Layer
      - Interacts with Data Access Layer to connect to the database
 */
@Service
public class ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    // Fetch a list of all contacts from address book
    public List<Contact> getContacts() {
        return contactRepository.findAll(Sort.by("name").ascending());
    }

    // Fetch a list of all unique contacts from two different address books
    public List<Contact> getUniqueContacts() {
        List<Contact> contact = new ArrayList<>();

        // TODO: add logic for checking unique entries in two different address books
        return contact;
    }


    // Add a new contact
    public void addNewContact(Contact contact) {
        contactRepository.save(contact);
    }
}
