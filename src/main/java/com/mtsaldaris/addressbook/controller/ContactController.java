package com.mtsaldaris.addressbook.controller;

import com.mtsaldaris.addressbook.model.Contact;
import com.mtsaldaris.addressbook.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    Contact Controller Class
     - Acts as the RESTful API layer where requests come in to the application
     - Leverages the Contact Service to GET/POST Contact data
 */

@RestController
@RequestMapping(path = "api/v1/contact")
public class ContactController {

    private final ContactService contactService;

    // Auto instantiated and inject Contact Service into the constructor
    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/getAll")
    public List<Contact> getContacts() {
        return contactService.getContacts();
    }

    @GetMapping("/getUnique")
    public List<Contact> getUniqueContacts() {
        return contactService.getUniqueContacts();
    }

    @PostMapping("/add")
    public void registerNewContact(@RequestBody Contact contact) {
        contactService.addNewContact(contact);
    }
}
