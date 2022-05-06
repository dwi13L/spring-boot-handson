package dev.danielwilliam.springboothandson.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.danielwilliam.springboothandson.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
