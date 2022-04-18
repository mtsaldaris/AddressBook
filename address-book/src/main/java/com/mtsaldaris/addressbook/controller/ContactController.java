package com.mtsaldaris.addressbook.controller;

import com.mtsaldaris.addressbook.model.Contact;
import com.mtsaldaris.addressbook.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/*
    Contact Controller Class
     - Acts as the RESTful API layer where requests come in to the application
     - Leverages the Contact Service to GET/POST Contact data
 */

@RestController
@RequestMapping(path = "api/v1/contact")
@CrossOrigin("http://localhost:3000/")
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
    public ResponseEntity<Contact> createNewContact(@Valid @RequestBody Contact contact) {
        Contact newContact = contactService.addNewContact(contact);
        return new ResponseEntity<Contact>(newContact, HttpStatus.CREATED);
    }
}
