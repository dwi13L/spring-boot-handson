package dev.danielwilliam.springboothandson.service.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.danielwilliam.springboothandson.entity.Contact;
import dev.danielwilliam.springboothandson.repository.ContactRepository;
import dev.danielwilliam.springboothandson.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {

    private ContactRepository repository;

    public ContactServiceImpl(ContactRepository repository) {
        this.repository = repository;
    }

    @Override
    public Contact createContact(Contact Contact) {
        return repository.save(Contact);
    }

    @Override
    public void deleteContact(long id) {
        repository.deleteById(id);

    }

    @Override
    public Contact updateContact(Contact contact) throws Exception {
        getContact(contact.getId());
        return repository.save(contact);
    }

    @Override
    public Contact getContact(long id) throws Exception {
        Optional<Contact> result = repository.findById(id);

        if (!result.isPresent()) {
            throw new Exception("No contact found");
        }

        return result.get();
    }

    @Override
    public List<Contact> getContact(String firstName) throws Exception {

        List<Contact> result = repository.findByFirstNameIgnoreCase(firstName);

        if (result == null || result.isEmpty()) {
            throw new Exception("No contact found");
        }

        return result;
    }

    @Override
    public List<Contact> getContact() throws Exception {
        List<Contact> result = repository.findAll();

        if (result == null || result.isEmpty()) {
            throw new Exception("No contact saved");
        }

        return result;
    }

}
