package dev.danielwilliam.springboothandson.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.danielwilliam.springboothandson.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    public List<Contact> findByFirstNameIgnoreCase(String firstName);
}
