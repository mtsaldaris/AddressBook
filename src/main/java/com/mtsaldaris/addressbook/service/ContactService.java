package com.mtsaldaris.addressbook.service;

import com.mtsaldaris.addressbook.model.Contact;
import com.mtsaldaris.addressbook.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
    Contact Service class from Contact model
 */
@Service
public class ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    // Fetch a list of all contacts from the database
    public List<Contact> getContacts() {
        return contactRepository.findAll();
    }

    // Add a new contact
    public void addNewContact(Contact contact) {
        contactRepository.save(contact);
    }
}
