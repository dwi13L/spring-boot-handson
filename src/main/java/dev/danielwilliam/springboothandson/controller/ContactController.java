package dev.danielwilliam.springboothandson.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.danielwilliam.springboothandson.entity.Contact;
import dev.danielwilliam.springboothandson.service.ContactService;

@RestController
@RequestMapping(value = "/v1")
public class ContactController {
    private ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    /**
     * API End Points
     */

    @PostMapping("/contact")
    public ResponseEntity<Contact> createContact(@Valid @RequestBody Contact contact) throws Exception {

        return new ResponseEntity<Contact>(contactService.createContact(contact),
                HttpStatus.CREATED);
    }

    @DeleteMapping("contact/{id}")
    public ResponseEntity<HttpStatus> deleteContact(@PathVariable("id") long id) {
        contactService.deleteContact(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/contact/{id}")
    public ResponseEntity<Contact> updateContact(@Valid @RequestBody Contact contact) throws Exception {

        return new ResponseEntity<Contact>(contactService.updateContact(contact), HttpStatus.OK);

    }

    @GetMapping("/contact")
    public ResponseEntity<List<Contact>> getAllContacts() throws Exception {

        return new ResponseEntity<>(contactService.getContact(), HttpStatus.OK);
    }

    @GetMapping("/contact/{id}")
    public ResponseEntity<Contact> getContact(@PathVariable long id) throws Exception {

        return new ResponseEntity<>(contactService.getContact(id), HttpStatus.OK);

    }

    @GetMapping("/contact/name/{firstName}")
    public ResponseEntity<List<Contact>> getContacts(@PathVariable String firstName) throws Exception {

        return new ResponseEntity<>(contactService.getContact(firstName), HttpStatus.OK);

    }

}
