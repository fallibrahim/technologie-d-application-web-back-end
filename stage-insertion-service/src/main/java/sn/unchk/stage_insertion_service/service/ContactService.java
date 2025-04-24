package sn.unchk.stage_insertion_service.service;

import sn.unchk.stage_insertion_service.models.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    Contact saveContact(Contact contact);
    List<Contact> getAllContacts();
    Optional<Contact> getContactById(Long id);
    void deleteContact(Long id);
    Contact updateContact(Long id, Contact contact);
}
