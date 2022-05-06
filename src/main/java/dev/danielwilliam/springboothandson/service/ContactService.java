package dev.danielwilliam.springboothandson.service;

import java.util.List;

import dev.danielwilliam.springboothandson.entity.Contact;

public interface ContactService {
    Contact createContact(Contact Contact);

    void deleteContact(long id);

    Contact updateContact(Contact contact) throws Exception;

    Contact getContact(long id) throws Exception;

    List<Contact> getContact(String firstName) throws Exception;

    List<Contact> getContact() throws Exception;

}
