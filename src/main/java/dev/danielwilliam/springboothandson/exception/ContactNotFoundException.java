package dev.danielwilliam.springboothandson.exception;

import lombok.Getter;

@Getter
public class ContactNotFoundException extends Exception {

    public ContactNotFoundException() {
        super("CONTACT_NOT_FOUND");
    }
}
